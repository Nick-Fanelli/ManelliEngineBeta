package com.manelliengine.engine.game;

import com.manelliengine.engine.views.View;
import com.manelliengine.engine.views.ViewManager;

public abstract class Manager {
	
	protected void SetActiveView(View view) {
		ViewManager.setActiveView(view);
	}

	public abstract void Start();
	
}
