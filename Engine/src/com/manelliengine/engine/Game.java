package com.manelliengine.engine;

import com.manelliengine.engine.View.View;
import com.manelliengine.engine.View.ViewManager;
import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.math.Time;
import com.manelliengine.engine.objects.GameObject;
import com.manelliengine.engine.window.Window;

public class Game implements Runnable {

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;

    private boolean running = false;
    private boolean render = false;
 
    private int width = 320, height = 240;
    private float scale = 3f;
    private String title = "Manelli Engine Beta";

    private double FPS_CAP = 1.0 / 60.0;
    private double deltaTime = 0;

    public Game(GameManager gameManager) {
        thread = new Thread(this);
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        
        gameManager.Init();
        
        View.setRenderer(renderer);
        GameObject.setVariables(this);
       
        
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
        deltaTime = 0;

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
                updateObjects();
                Time.updateDt(this);
                if(ViewManager.getActiveView() != null) {
                	ViewManager.getActiveView().Update();
                }
                //Update Input Last
                input.update();
            }

            if(render) {
                renderer.clear();
                ViewManager.getActiveView().Render();
                renderObjects();
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
    
    private void updateObjects() {
    	for(int i = 0; i < ViewManager.getGameObjectsAsArrayList().size(); i++) {
    		 ViewManager.getGameObjectsAsArrayList().get(i).Update();
    	}
    }
    
    private void renderObjects() {
    	for(int i = 0; i < ViewManager.getGameObjectsAsArrayList().size(); i++) {
    		ViewManager.getGameObjectsAsArrayList().get(i).Render();
    	}
    }

    public String getTitle() {
        return title;
    }
    public Window getWindow() {return window;}
    
    public float getDeltaTime() {
    	return (float) deltaTime;
    }
    
    public Renderer getRenderer() {
    	return renderer;
    }
    
    public Input getInput() {
    	return input;
    }
}
