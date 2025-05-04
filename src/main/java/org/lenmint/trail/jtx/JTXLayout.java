package org.lenmint.trail.jtx;

import org.lenmint.trail.elements.Window;
import org.lenmint.trail.elements.properties.Tag;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;

public class JTXLayout {
    private org.w3c.dom.Element rootElement;

    private Window window;

    public JTXLayout(InputStream content) {
        paresContent(content);
        getRoot();
        getRootChildren();
    }

    private void paresContent(InputStream content) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(content);
            rootElement = document.getDocumentElement();
            rootElement.normalize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void getRoot() {
        // Get main Window node form jtx file
        if (!rootElement.getTagName().equals(Tag.Window.toString())) {
            throw new IllegalArgumentException("Root document must be a '" + Tag.Window + "' element.");
        }

        // Make the Window
        this.window = JTXMaker.makeWindow(rootElement);
    }

    private void getRootChildren() {
        // Get all nodes
        NodeList nodes = rootElement.getChildNodes();
        HashMap<Node, Tag> validNodes = new HashMap<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i).getNextSibling();

            if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                String tag = node.getNodeName();

                if (Tag.getListString().contains(tag) && !tag.equals(Tag.Window.toString())) {
                    validNodes.put(node, Tag.valueOf(tag));
                }
                // Exceptions
                else if (tag.equals(Tag.Window.toString()))
                    throw new IllegalArgumentException("JTX Error::Layout file can only has one " + Tag.Window + " element");
                else
                    throw new IllegalArgumentException("JTX Error::Unknown element: [" + tag + "]");
            }
        }

        // Convert all valid Nodes to Elements & set them to root window as children
        window.setChildren(JTXMaker.make(validNodes));
    }

    public Window getWindow() {
        return window;
    }
}
