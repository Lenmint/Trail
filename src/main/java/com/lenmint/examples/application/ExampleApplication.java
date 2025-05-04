package com.lenmint.examples.application;

import org.lenmint.trail.Application;

public class ExampleApplication extends Application {
    @Override
    public void OnCreate() {
        super.OnCreate();
        // Set Window layout
        setContent("layouts/window.jtx");
    }
}
