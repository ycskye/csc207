package com.example.boundless.utilities;

import android.graphics.Bitmap;
import android.graphics.Paint;

import com.example.boundless.MainThread;

/**
 * Draws things on the screen
 */
public class DrawUtility {
    private static Paint paint = new Paint();

    private DrawUtility() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Draws a rectangle on the canvas
     *
     * @param coords The four coordinates, indexes 0-3 of the given array
     * @param color  The color to draw the rectangle
     */
    public static void drawRectangle(int[] coords, int color) {
        if (coords.length < 4)
            throw new ArrayIndexOutOfBoundsException("You must have at least 4 coordinates to draw a rectangle.");
        paint.setColor(color);
        MainThread.canvas.drawRect(coords[0], coords[1], coords[2], coords[3], paint);
    }

    /**
     * Draws a line on the canvas
     *
     * @param coords The four coordinates, startX, startY, endX, endY
     * @param color  The color to draw the line
     * @param width  The width to draw the line
     */
    public static void drawLines(int[] coords, int color, int width) {
        paint.setColor(color);
        paint.setStrokeWidth(width);
        MainThread.canvas.drawLine(coords[0], coords[1], coords[2], coords[3], paint);
    }

    /**
     * Draws a string on the canvas
     *
     * @param text  The string to draw
     * @param x     The x coordinate to draw it at
     * @param y     The y coordinate to draw it at
     * @param color The color to draw the string in
     * @param size  The text size to draw the string in
     */
    public static void drawString(String text, int x, int y, int color, int size) {
        paint.setColor(color);
        paint.setTextSize(size);
        MainThread.canvas.drawText(text, x, y, paint);
    }

    /**
     * Draw a bitmap image on the canvas
     * @param bitmap The bitmap to draw
     * @param x The x location to draw the bitmap at
     * @param y The y location to draw the bitmap at
     */
    public static void drawBitmap(Bitmap bitmap, int x, int y){
        MainThread.canvas.drawBitmap(bitmap, x, y, paint);
    }
}
