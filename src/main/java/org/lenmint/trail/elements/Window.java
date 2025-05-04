package org.lenmint.trail.elements;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Window extends Element {

    private JFrame jFrame;

    private String title = "Window";

    private int width;
    private int height;
    private int xPosition, yPosition;
    private int maxWidth;
    private int maxHeight;
    private int minWidth;
    private int minHeight;

    private float opacity = 1;

    private ImageIcon icon;
    private Cursor cursor;
    private Color background = Color.white;
    private Locale locale = Locale.ENGLISH;
    private Font font;

    private boolean enabled = true;
    private boolean resizeable = true;
    private boolean alwaysOnTop = false;
    private boolean focusable = true;
    private boolean centerOfScreen = false;

    public Window() {
        initialize();
    }

    public Window(String title) {
        this.title = title;
        initialize();
    }

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        initialize();
    }

    @Override
    public void initialize() { }

    @Override
    public void build() {
        jFrame = new JFrame(title);

        jFrame.setSize(new Dimension(width, height));
        jFrame.setPreferredSize(new Dimension(width, height));
        jFrame.setMinimumSize(new Dimension(minWidth, minHeight));
        jFrame.setMaximumSize(new Dimension(maxWidth, maxHeight));
        jFrame.pack();

        if (centerOfScreen) {
            jFrame.setLocationRelativeTo(null);
        }
        else jFrame.setLocation(xPosition, yPosition);

        jFrame.setEnabled(enabled);
        jFrame.setResizable(resizeable);
        jFrame.setFocusable(focusable);
        jFrame.setAlwaysOnTop(alwaysOnTop);
        jFrame.setCursor(cursor);

        // TEMPORARY: Show Window
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set window to exit when click the close btn
    }

    public JFrame getFrame() {
        return jFrame;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isResizeable() {
        return resizeable;
    }

    public void setResizeable(boolean resizeable) {
        this.resizeable = resizeable;
    }

    public boolean isAlwaysOnTop() {
        return alwaysOnTop;
    }

    public void setAlwaysOnTop(boolean alwaysOnTop) {
        this.alwaysOnTop = alwaysOnTop;
    }

    public boolean isFocusable() {
        return focusable;
    }

    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
    }

    public boolean isCenterOfScreen() {
        return centerOfScreen;
    }

    public void setCenterOfScreen(boolean centerOfScreen) {
        this.centerOfScreen = centerOfScreen;
    }
}
