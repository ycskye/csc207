package com.example.boundless;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    public static final int MAX_FPS = 30;
    private Panel panel;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private boolean running;
    public static Canvas canvas;


    public MainThread(SurfaceHolder surfaceHolder, Panel panel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.panel = panel;
    }

    @Override
    public void run() {
        long startTime;
        long timeMills = 1000 / MAX_FPS;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000 / MAX_FPS;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.panel.update();
                    this.panel.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            timeMills = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMills;
            try {
                if (waitTime > 0) {
                    this.sleep(waitTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == MAX_FPS) {
                averageFPS = 1000 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}