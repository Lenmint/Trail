package org.lenmint.trail.jtx;

import org.lenmint.trail.Helper;
import org.lenmint.trail.elements.Element;
import org.lenmint.trail.elements.Window;
import org.lenmint.trail.elements.properties.Cursor;
import org.lenmint.trail.elements.properties.Tag;
import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class JTXMaker {

    public static Window makeWindow(org.w3c.dom.Element rootElement) {
        // Creating the window
        Window window = new Window();

        // Set Window values
        for (int i = 0; i < rootElement.getAttributes().getLength(); i++) {
            Node item = rootElement.getAttributes().item(i);
            String value = item.getNodeValue();

            switch (item.getNodeName()) {
                case "title" -> window.setTitle(value);

                case "width" -> window.setWidth(Integer.parseInt(value));
                case "height" -> window.setHeight(Integer.parseInt(value));
                case "minWidth" -> window.setMinWidth(Integer.parseInt(value));
                case "minHeight" -> window.setMinHeight(Integer.parseInt(value));
                case "maxWidth" -> window.setMaxWidth(Integer.parseInt(value));
                case "maxHeight" -> window.setMaxHeight(Integer.parseInt(value));

                case "xPosition" -> window.setXPosition(Integer.parseInt(value));
                case "yPosition" -> window.setYPosition(Integer.parseInt(value));
                case "opacity" -> window.setOpacity(Float.parseFloat(value));

                case "enabled" -> window.setEnabled(Boolean.parseBoolean(value));
                case "resizeable" -> window.setResizeable(Boolean.parseBoolean(value));
                case "alwaysOnTop" -> window.setAlwaysOnTop(Boolean.parseBoolean(value));
                case "focusable" -> window.setFocusable(Boolean.parseBoolean(value));
                case "centerOfScreen" -> window.setCenterOfScreen(Boolean.parseBoolean(value));

                case "cursor" -> window.setCursor(new java.awt.Cursor(Cursor.valueOf(value.toUpperCase()).getValue()));
                case "icon" -> {
                    if (JTXBinding.isBinding(value, JTXBinding.Binding.Resources)) {
                        // Get icon from resource folder
                        try {
                            String path = JTXBinding.getResourcesBindValue(value);
                            URL iconUrl = window.getClass().getResource(Helper.fixedPath(path));

                            if (iconUrl != null) {
                                ImageIcon icon = new ImageIcon(iconUrl);
                                window.setIcon(icon);
                            } else
                                throw new RuntimeException("JTX Error: Resource not found in: " + path);

                        } catch (RuntimeException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // Get icon from external folder
                        window.setIcon(new ImageIcon(value));
                        window.setFont(Font.getFont(""));
                    }
                }
                // TODO: Complete attributes

                default ->
                        throw new IllegalArgumentException("JTX Error::Unknown Window attribute: " + item.getNodeName());
            }
        }

        return window;
    }

    public static ArrayList<Element> make(HashMap<Node, Tag> nodes) {
        ArrayList<Element> elements = new ArrayList<>();
        for (Map.Entry<Node, Tag> entry : nodes.entrySet()) {
            Node node = entry.getKey();
            Tag tag = entry.getValue();

            switch (tag) {
                // TODO: Implement creating element
                default -> throw new IllegalStateException("JTX Error::Unexpected value: " + tag);
            }
        }

        return null;
    }
}
