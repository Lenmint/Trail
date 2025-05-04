package org.lenmint.trail.elements;

import java.util.ArrayList;

public abstract class Element {
    private String id = null;
    private ArrayList<Element> children = null;

    protected abstract void initialize();
    public abstract void build();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Element> getChildren() {
        return children;
    }
    public void setChildren(ArrayList<Element> children) {
        this.children = children;
    }
    public void addChild(Element child) {
        if (children == null)
            children = new ArrayList<>();
        children.add(child);
    }
}
