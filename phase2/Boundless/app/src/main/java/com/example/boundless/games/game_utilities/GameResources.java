package com.example.boundless.games.game_utilities;

import android.graphics.Color;

import com.example.boundless.Panel;

/**
 * Holds the resources for each game, e.g. "game over" strings and magic constants
 */
public final class GameResources {
    private GameResources() {
    }

    //region Shop
    /**
     * The cost of each shop item
     */
    public static final int ITEM_COST = 3;

    //region Pixel game
    /**
     * The alpha value of the pixels
     */
    public static final int ALPHA_VALUE = 200;
    /**
     * The x start position for the pixel grid on the screen
     */
    public static final int PIXEL_START_X = 150;
    /**
     * The y start position for the pixel grid on the screen
     */
    public static final int PIXEL_START_Y = Panel.SCREEN_HEIGHT / 4;
    /**
     * The color of the unfilled pixels in the pixel game
     */
    public static final int PIXEL_EMPTY_COLOR = Color.argb(ALPHA_VALUE, 0, 0, 0);
    /**
     * The color of the X pixels in the  pixel game
     */
    public static final int PIXEL_X_COLOR = Color.argb(ALPHA_VALUE, 143, 143, 143);
    /**
     * The number of frames to show the pixel hint for
     */
    public static final int PIXEL_HINT_FRAMES = 8;
    /**
     * Gets the game over text for the pixel game
     *
     * @param finishedLevel The level the user has finished
     * @return The string to show to the user.
     */
    public static String getPixelGameOver(int finishedLevel) {
        return "GAME COMPLETED!\nYou just finished level " + finishedLevel;
    }

    /**
     * Gets the instructions text for the pixel game
     *
     * @return The string to show the user.
     */
    public static String getPixelInstructions() {
        return "Use the column and row numbers as a guide to create a picture:\n" +
                "each row and column has a number of groupings of pixels (e.g. 10 means 10 pixels in a row in that row or column)";
    }
    //endregion

    //region Tile game

    /**
     * The x start position for the pixel grid on the screen
     */
    public static final int TILE_START_X = 100;
    /**
     * The y start position for the pixel grid on the screen
     */
    public static final int TILE_START_Y = Panel.SCREEN_HEIGHT / 4;

    /**
     * Gets the game over text for the tile game
     *
     * @param finishedLevel The level the user has finished
     * @return The string to show to the user.
     */
    public static String getRotateTileGameOver(int finishedLevel) {
        return "GAME COMPLETED!\nYou just finished the rotate tiles game level #" + finishedLevel;
    }

    /**
     * Gets the instructions text for the tile game
     *
     * @return The string to show the user.
     */
    public static String getRotateTileInstructions() {
        return "Rotate the tiles to get water from the upper left hand pipe" + " to the lower right hand pipe.";
    }

    //endregion

    //region GPA catcher game

    /**
     * The pixel size of the basket
     */
    public static final int GPAGAME_BASKET_SIZE = 250;

    /**
     * The number of lives the player starts with
     */
    public static final int GPAGAME_STARTING_LIVES = 3;


    /**
     * The default falling speed of falling objects
     */

    public static final int GPAGAME_DEFAULT_FALLING_SPEED = 15;

    /**
     * The Max Time allowed for the game
     */
    public static final double GPAGAME_MAX_TIME = 1000;

    /**
     * the starting GPA for the user
     */
    public static final double GPAGAME_STARTING_GPA = 2.5;

    /**
     * The pixel size of the heart icon
     */
    public static final int HEART_SIZE = 60;

    /**
     * The default basket speed
     */
    public static final int GPAGAME_DEFAULT_BASKET_SPEED = 15;

    /**
     * Default amount of time to decrease by, every time the panel updates
     */
    public static final int GPAGAME_DEFAULT_TIME_DECREMENT = 1;

    /**
     * Maximum number of allowed falling objects allowed on the screen at once
     */
    public static final int GPAGAME_MAX_NUMBER_OF_FALLING_OBJECTS = 10;


    /**
     * Maximum number of Lives the player can have
     */
    public static final int GPAGAME_MAXIMUM_NUMBER_OF_LIVES = 3;

    /**
     * Default amount of restored time
     */
    public static final int GPAGAME_INCREASE_TIME_BY = 100;


    /**
     * Gets the game over text for the GPA Game
     *
     * @return The string to show to the user.
     */
    public static String getGPAGameOver() {
        return "GAME OVER! \n";
    }

    /**
     * Gets the instructions text for the GPA Game
     *
     * @return The string to show the user.
     */
    public static String getGPAGameInstructions() {
        return "Tap on the left or right sides of the screen to move the character.\n" +
                "Try to get all the assignments and sleep you can get, but be careful of bombs!";
    }

    //endregion
}
