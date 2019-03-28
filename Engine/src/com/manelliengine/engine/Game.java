package com.manelliengine.engine;

import com.manelliengine.engine.View.ViewManager;
import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.window.Window;

public class Game implements Runnable {

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private ViewManager viewManager;

    private boolean running = false;
    private boolean render = false;

    private int width = 320, height = 240;
    private float scale = 3f;
    private String title = "Manelli Engine Beta";

    private double FPS_CAP = 1.0 / 60.0;

    public Game(GameManager gameManager) {
        thread = new Thread(this);
        window = new Window(this);
        renderer = new Renderer(this);

        gameManager.Init();

        thread.run();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    @Override
    public void run() {
        running = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000D;
        double passedTime = 0;
        double deltaTime = 0;

        while(running) {

            render = false;

            firstTime = System.nanoTime() / 1000000000D;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            deltaTime += passedTime;

            while(deltaTime >= FPS_CAP) {
                deltaTime -= FPS_CAP;
                render = true;
                //TODO: Update
                //Update Input Last
            }

            if(render) {
                renderer.clear();
                // TODO: Update Text Here
                window.update();
            } else {
                try {
                    Thread.sleep(1);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        cleanUp();
    }

    public static void cleanUp() {

    }

    public String getTitle() {
        return title;
    }
    public Window getWindow() {return window;}

}
