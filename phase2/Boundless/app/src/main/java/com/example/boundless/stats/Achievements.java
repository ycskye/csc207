package com.example.boundless.stats;

import com.example.boundless.games.GamesEnum;

/**
 * The achievements for a given game
 */
public class Achievements {

    private static boolean maxGpaAchieve = false;
    private static boolean threeGpaAchieve = false;
    private static boolean failGpaAchieve = false;

    private static int numPixelTaps = 0;
    private static boolean twentySecondsOrLessPixel = false;

    private static int numRotateTaps = 0;
    private static boolean twentySecondsOrLessRotate = false;

    private Achievements() {
    }

    /**
     * Checks if the players GPA satisfies any of the GPA Catcher game achievements
     *
     * @param gpa represents the players final gpa score when the GPA Catcher game ends
     */
    public static void gpaChecker(double gpa) {
        Double gpaHolder = gpa;
        if (gpaHolder.equals(4.0)) {
            maxGpaAchieve = true;
        } else if (gpaHolder.equals(3.0)) {
            threeGpaAchieve = true;
        } else if (gpaHolder.equals(0.0)) {
            failGpaAchieve = true;
        }
    }

    /**
     * Checks if the players time in Rotate Tile/Pixel game is less than 20 seconds for achievements
     *
     * @param gamesEnum   the enum representing the game that was just completed
     * @param elapsedTime is the amount of time spent to complete the game
     */
    static void checkTime(GamesEnum gamesEnum, long elapsedTime) {

        if (gamesEnum == GamesEnum.ROTATETILE) {
            if (elapsedTime <= 20) {
                twentySecondsOrLessRotate = true;
            }
        } else if (gamesEnum == GamesEnum.PIXELS) {
            if (elapsedTime <= 20) {
                twentySecondsOrLessPixel = true;
            }
        }
    }

    /**
     *
     * Getter for maxGpaAchieve's value
     *
     * @return boolean for whether player got 4.0 GPA
     */
    public static boolean isMaxGpaAchieve() {
        return maxGpaAchieve;
    }

    /**
     *
     * Getter for threeGpaAchieve's value
     *
     * @return boolean for whether player got 3.0 GPA
     */
    public static boolean isThreeGpaAchieve() {
        return threeGpaAchieve;
    }

    /**
     *
     * Getter for failGpaAchieve's value
     *
     * @return boolean for whether player got 0.0 GPA
     */
    public static boolean isFailGpaAchieve() {
        return failGpaAchieve;
    }

    /**
     *
     * Getter for numPixelTaps
     *
     * @return int for number of screen clicks in Pixel Game
     */
    public static int getNumPixelTaps() {
        return numPixelTaps;
    }

    /**
     * Setter for numPixelTaps (number of screen clicks in Pixel Game)
     */
    public static void setNumPixelTaps() {
        Achievements.numPixelTaps = numPixelTaps + 1;
    }

    /**
     *
     * Getter for twentySecondsOrLessPixel boolean value
     *
     * @return boolean for whether player finished pixel game in less than 20 seconds
     */
    public static boolean isTwentySecondsOrLessPixel() {
        return twentySecondsOrLessPixel;
    }

    /**
     *
     * Setter for twentySecondsOrLessPixel value
     *
     * @param twentySecondsOrLessPixel sets twentySecondsOrLessPixel boolean value to this boolean
     *                                 if Pixel game stage is completed in less than twenty seconds
     */
    public static void setTwentySecondsOrLessPixel(boolean twentySecondsOrLessPixel) {
        Achievements.twentySecondsOrLessPixel = twentySecondsOrLessPixel;
    }


    /**
     * Getter for numRotateTaps
     *
     * @return int for number of screen clicks in Rotate Tile Game
     */
    public static int getNumRotateTaps() {
        return numRotateTaps;
    }

    /**
     * Setter for numRotateTaps
     */
    public static void setNumRotateTaps() {
        Achievements.numRotateTaps = numRotateTaps + 1;
    }

    /**
     *
     * Getter for TwentySecondsOrLessRotate
     *
     * @return boolean for whether player has finished Rotate game in less than twenty seconds
     */
    public static boolean isTwentySecondsOrLessRotate() {
        return twentySecondsOrLessRotate;
    }

    /**
     *
     * Setter for TwentySecondsOrLessRotate
     *
     * @param twentySecondsOrLessRotate sets twentySecondsOrLessRotate boolean value to this boolean
     *                                  if Rotate game stage is completed in less than twenty seconds
     */
    public static void setTwentySecondsOrLessRotate(boolean twentySecondsOrLessRotate) {
        Achievements.twentySecondsOrLessRotate = twentySecondsOrLessRotate;
    }
}