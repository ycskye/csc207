package com.example.boundless.stats;

import com.example.boundless.games.GamesEnum;
import com.example.boundless.users.UserAccountManager;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The statistics for a given game
 */
public class Statistics {

    private static long startTime;
    private static long startTimePixel;
    private static long startTimeRotate;

    private static long timeElapsedSeconds;
    private static int totalScore;
    private static int counterClicks;

    private Statistics() {}

    /**
     * Starts measuring time
     */
    public static void start() {
        startTime = new Date().getTime();
    }

    /**
     * Start measuring time for Pixel or Rotate game depending on enum passed in
     *
     * @param gamesEnum the enum representing the game we want to measure time for
     */
    public static void startTimeByGame(GamesEnum gamesEnum) {
        if (gamesEnum == GamesEnum.PIXELS)
            startTimePixel = new Date().getTime();
        else if (gamesEnum == GamesEnum.ROTATETILE)
            startTimeRotate = new Date().getTime();
    }

    /**
     * Stops measuring time
     */
    public static void end() {
        long endTime = new Date().getTime();
        long timeElapsed = endTime - startTime;
        timeElapsedSeconds += TimeUnit.MILLISECONDS.toSeconds(timeElapsed);
    }

    /**
     * Stop measuring time for Pixel or Rotate game depending on enum passed in
     *
     * @param gamesEnum the enum representing the game we want to stop measuring time for
     */
    public static void endTimeByGame(GamesEnum gamesEnum) {

        if (gamesEnum == GamesEnum.PIXELS) {

            long timeElapsedSecondsPixel = 0;
            long endTime = new Date().getTime();
            long timeElapsed = endTime - startTimePixel;
            timeElapsedSecondsPixel += TimeUnit.MILLISECONDS.toSeconds(timeElapsed);
            if (timeElapsedSecondsPixel <= 20) {
                Achievements.checkTime(gamesEnum, timeElapsedSecondsPixel);
            }
        } else if (gamesEnum == GamesEnum.ROTATETILE) {

            long timeElapsedSecondsRotate = 0;
            long endTime = new Date().getTime();
            long timeElapsed = endTime - startTimeRotate;
            timeElapsedSecondsRotate += TimeUnit.MILLISECONDS.toSeconds(timeElapsed);
            if (timeElapsedSecondsRotate <= 20) {
                Achievements.checkTime(gamesEnum, timeElapsedSecondsRotate);
            }
        }
    }

    /**
     * returns a random integer between 2-7
     */
    private static int addRandomScore() {
        Random ran = new Random();
        return ran.nextInt(6) + 2;
    }

    /**
     * adds output of addRandomScore() to total score
     */
    public static void sumTotalScore() {
        int additionalScore = addRandomScore();
        totalScore += additionalScore;
        UserAccountManager.currentUser.addUserPoints(additionalScore);
    }

    /**
     * counts the number of clicks on the screen during the game
     */
    public static void clickEvent() {
        counterClicks += 1;
    }

    /**
     * returns an integer representing the total number of clicks
     */
    public static int totalClicks() {
        return counterClicks;
    }

    /**
     * returns string formatting of the statistics
     */
    public static String printStats() {
        return "Total Time in Game (Seconds): " + timeElapsedSeconds + "\n" +
                "Total Points: " + totalScore + "\n" +
                "Total Number of Taps on Screen: " + counterClicks + "\n" +
                "Thanks for Playing!";
    }
}
