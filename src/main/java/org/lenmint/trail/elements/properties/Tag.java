package org.lenmint.trail.elements.properties;

import java.util.ArrayList;

public enum Tag {
    Window;

    public static ArrayList<String> getListString() {
        ArrayList<String> list = new ArrayList<>();
        // Add here all available tags
        list.add(Window.name());
        return list;
    }
}
