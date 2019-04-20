package com.manelliengine.engine;

import com.manelliengine.engine.gfx.Button;
import com.manelliengine.engine.gfx.ButtonManager;
import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.math.Time;
import com.manelliengine.engine.objects.GameObject;
import com.manelliengine.engine.view.View;
import com.manelliengine.engine.view.ViewManager;
import com.manelliengine.engine.window.Window;

public class Game implements Runnable {

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private ButtonManager buttonManager;

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
        buttonManager = new ButtonManager();
        
        gameManager.Init();
        
        View.setRenderer(renderer);
        GameObject.setVariables(this);
        View.setVariables(this);
        Button.setVariables(this);
        
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
                update();
            }

            if(render) {
               render();
            } else {
                try {
                    Thread.sleep(1);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void update() {
    	// Update Objects
        updateObjects();
        
        // Update Delta Time
        Time.updateDt(this);
        
        // Update View
        if(ViewManager.getActiveView() != null) {
        	ViewManager.getActiveView().Update();
        }
        
        // Update Button Check
        updateButtons();
        
        //Update Input Last (Make Sure It's Last)
        input.update();
    }
    
    private void render() {
    	// Clear the Screen
    	 renderer.clear();
    	 
    	 // Render the Active View
	     if(ViewManager.getActiveView() != null) {
	     	ViewManager.getActiveView().Render();
	     }
	     
	     // Render The Objects
	     renderObjects();
	     
	     // Render/Draw the buttons
	     drawButtons();

	     // Render/Update the window (Do Last)
	     window.update();
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
    
    private void drawButtons() {
    	if(buttonManager.getButtonsInGame() != null) {
    		for(int i = 0; i < buttonManager.getButtonsInGame().size(); i++) {
    			buttonManager.getButtonsInGame().get(i).draw();
    		}
    	}
    }
    
    private void updateButtons() {
    	if(buttonManager.getButtonsInGame() != null) {
    		for(int i = 0; i < buttonManager.getButtonsInGame().size(); i++) {
    			buttonManager.getButtonsInGame().get(i).update();
    		}
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
