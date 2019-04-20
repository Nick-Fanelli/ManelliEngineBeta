package com.manelliengine.engine.view;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.gfx.Button;
import com.manelliengine.engine.gfx.ButtonManager;
import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.math.Position;
import com.manelliengine.engine.objects.GameObject;
import com.manelliengine.engine.physics.PhysicsEngine;

public abstract class View {
	
	protected static Renderer r;
	protected static PhysicsEngine PhysicsEngine;
	
	public static void setRenderer(Renderer r) {
		View.r = r;
	}
	
	public static void setVariables(Game game) {
		PhysicsEngine = new PhysicsEngine(game);
	}
	
	protected void MoveGameObject(GameObject gameObject, Position position) {
		moveGameObject(gameObject, position);
	}

	protected void MoveGameObject(String tag, Position position) {
		moveGameObject(ViewManager.getObjects().get(tag), position);
	}
	
	private void moveGameObject(GameObject gameObject, Position position) {
		gameObject.transform.position = position;
	}
	
	protected void CreateButton(Button button) {
		ButtonManager.createButton(button);
	}
	
	protected void DestoryButton(Button button) {
		ButtonManager.destoryButton(button);
	}
	
	protected void CreateGameObject(GameObject gameObject, String tag) {
		ViewManager.createGameObject(gameObject, tag);
	}
	
	protected void DestroyGameObject(String tag) {
		ViewManager.destroyGameObject(tag);
	}
	
    public abstract void onCreate();
    public abstract void Update();
    public abstract void Render();
    public abstract void onDestory();

}
