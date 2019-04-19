package com.manelliengine.engine.View;

import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.objects.GameObject;

public abstract class View {
	
	protected static Renderer r;
	
	public static void setRenderer(Renderer r) {
		View.r = r;
	}
	
	protected void CreateGameObject(GameObject gameObject, String tag) {
		ViewManager.createGameObject(gameObject, tag);
	}
	
    public abstract void onCreate();
    public abstract void Update();
    public abstract void Render();
    public abstract void onDestory();

}
