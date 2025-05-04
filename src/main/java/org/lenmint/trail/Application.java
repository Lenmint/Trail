package org.lenmint.trail;

import org.lenmint.trail.elements.Window;
import org.lenmint.trail.jtx.JTXLayout;

import java.io.*;
import java.net.URL;

public class Application extends Event {

    private JTXLayout jtxLayout;
    private Window window;

    /// Used to run the application
    public void Run() {
        OnCreate();
    }

    @Override
    public void OnCreate() { }

    @Override
    public void OnStart() {
        window.build();

        // TODO: Build all window children
    }

    @Override
    public void OnRender() {
        window = jtxLayout.getWindow();
    }

    /// Set main layout file to render it
    public void setContent(String path) {
        path = Helper.fixedPath(path);

        if (!path.endsWith("jtx")) {
            throw new IllegalArgumentException("File is not a `.jtx` file.");
        }

        URL content = getClass().getResource(path);

        if (content != null) {
            try {
                jtxLayout = new JTXLayout(content.openStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("JTX Layout no found in: " + path);
        }

        OnRender();
        OnStart();
    }

    public Window getWindow() {
        return window;
    }
}
