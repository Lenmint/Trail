package org.lenmint.trail.elements.properties;

public enum Cursor {
    DEFAULT_CURSOR,
    /**
     * The cross-hair cursor type.
     */
    CROSSHAIR_CURSOR,
    /**
     * The text cursor type.
     */
    TEXT_CURSOR,
    /**
     * The wait cursor type.
     */
    WAIT_CURSOR,
    /**
     * The south-west-resize cursor type.
     */
    SW_RESIZE_CURSOR,
    /**
     * The south-east-resize cursor type.
     */
    SE_RESIZE_CURSOR,
    /**
     * The north-west-resize cursor type.
     */
    NW_RESIZE_CURSOR,
    /**
     * The north-east-resize cursor type.
     */
    NE_RESIZE_CURSOR,
    /**
     * The north-resize cursor type.
     */
    N_RESIZE_CURSOR,
    /**
     * The south-resize cursor type.
     */
    S_RESIZE_CURSOR,
    /**
     * The west-resize cursor type.
     */
    W_RESIZE_CURSOR,
    /**
     * The east-resize cursor type.
     */
    E_RESIZE_CURSOR,
    /**
     * The hand cursor type.
     */
    HAND_CURSOR,
    /**
     * The move cursor type.
     */
    MOVE_CURSOR;

    public int getValue() {
        switch (this) {
            case DEFAULT_CURSOR -> {
                return java.awt.Cursor.DEFAULT_CURSOR;
            }
            case CROSSHAIR_CURSOR -> {
                return java.awt.Cursor.CROSSHAIR_CURSOR;
            }
            case TEXT_CURSOR -> {
                return java.awt.Cursor.TEXT_CURSOR;
            }
            case WAIT_CURSOR -> {
                return java.awt.Cursor.WAIT_CURSOR;
            }
            case SW_RESIZE_CURSOR -> {
                return java.awt.Cursor.SW_RESIZE_CURSOR;
            }
            case SE_RESIZE_CURSOR -> {
                return java.awt.Cursor.SE_RESIZE_CURSOR;
            }
            case NW_RESIZE_CURSOR -> {
                return java.awt.Cursor.NW_RESIZE_CURSOR;
            }
            case NE_RESIZE_CURSOR -> {
                return java.awt.Cursor.NE_RESIZE_CURSOR;
            }
            case N_RESIZE_CURSOR -> {
                return java.awt.Cursor.N_RESIZE_CURSOR;
            }
            case S_RESIZE_CURSOR -> {
                return java.awt.Cursor.S_RESIZE_CURSOR;
            }
            case W_RESIZE_CURSOR -> {
                return java.awt.Cursor.W_RESIZE_CURSOR;
            }
            case E_RESIZE_CURSOR -> {
                return java.awt.Cursor.E_RESIZE_CURSOR;
            }
            case HAND_CURSOR -> {
                return java.awt.Cursor.HAND_CURSOR;
            }
            case MOVE_CURSOR -> {
                return java.awt.Cursor.MOVE_CURSOR;
            }

            default -> throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
