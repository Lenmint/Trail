package org.lenmint.trail;

public abstract class Event {

    /// Called when the application created.
    protected abstract void OnCreate();

    /// Called when load content
    protected void OnRender() { }

    /// Called after load content
    protected void OnStart() { }
}
