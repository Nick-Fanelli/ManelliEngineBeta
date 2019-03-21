package com.manelliengine.engine.game;

import com.manelliengine.engine.ExitCode;
import com.manelliengine.engine.Input;
import com.manelliengine.engine.gfx.Renderer;
import com.manelliengine.engine.objects.GameObject;
import com.manelliengine.engine.objects.ObjectManager;
import com.manelliengine.engine.objects.PreObject;
import com.manelliengine.engine.platform.Platform;
import com.manelliengine.engine.views.ViewManager;
import com.manelliengine.engine.window.Window;

public class Game implements Runnable {

	private Thread thread;
	private Window window;
	private Renderer renderer;
	private Manager manager;
	private PreObject preObject;
	private GameObject gameObject;
	private ObjectManager objectManager;
	private Input input;
	
	private String title = "Manelli Engine Beta";
	
	private int width, height;
	private float scale;
	private Platform platform;
	
	private boolean isRunning = false;
	private boolean render = false;
	
	private double FPS_CAP = 1.0 / 60.0;
	
	public Game(Manager manager, int width, int height, float scale, Platform platform) {
		this.platform = platform;
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.manager = manager;
		
		window = new Window(this);
		renderer = new Renderer(this);
		preObject = new PreObject(null, null, this);
		input = new Input(this);
		
		gameObject = preObject.getObject();
		objectManager = new ObjectManager();
		
		gameObject.init(this);
		objectManager.init(this);
		
		thread = new Thread(this);
		thread.run();
	}
	
	@Override
	public void run() {
		isRunning = true;
		
		manager.Start();
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000D;
		double passedTime = 0;
		double deltaTime = 0;
		
		while(isRunning) {
			
			render = false;
			
			firstTime = System.nanoTime() / 1000000000D;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			deltaTime += passedTime;
			
			while(deltaTime >= FPS_CAP) {
				deltaTime -= FPS_CAP;
				render = true;
				// Update Game
				ViewManager.update();
				ObjectManager.update();
				// Handle Input Last
				input.update();
			}
			
			if(render) {
				renderer.clear();
				ObjectManager.render();
				// TODO: Render
				window.update();
			} else {
				try {
					Thread.sleep(1);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		cleanUp(ExitCode.Failed);
	}
	
	public static void cleanUp(ExitCode exitcode) {
		ObjectManager.cleanUp();
		System.exit(exitcode.ordinal());
	}

	public String getTitle() {
		return title;
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
	
	public Window getWindow() {
		return window;
	}

	public Platform getPlatform() {
		return platform;
	}
	
	public Renderer getRenderer() {
		return renderer;
	}
	
	public PreObject getPreObject() {
		return preObject;
	}
	
	public Input getInput() {
		return input;
	}
	
}
