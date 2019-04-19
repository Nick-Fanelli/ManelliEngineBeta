package com.manelliengine.engine.objects;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.Input;
import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.physics.PhysicsEngine;

public abstract class GameObject {

	public Transform transform;
	protected static Renderer r; 
	protected static Input input;
	protected static PhysicsEngine PhysicsEngine = new PhysicsEngine();
	
	public GameObject(Transform transform) {
		this.transform = transform;
	}
	
	public static void setVariables(Game game) {
		r = game.getRenderer();
		input = game.getInput();
	}
	
	public abstract void onCreate();
	public abstract void Update();
	public abstract void Render();
	public abstract void onDestory();
	
}
