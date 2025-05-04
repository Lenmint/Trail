package org.lenmint.trail;

public abstract class Helper {
    public static String fixedPath(String path) {
        if (!path.startsWith("/")) {
            return "/" + path;
        }
        return path;
    }
}
