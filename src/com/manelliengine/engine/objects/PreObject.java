package com.manelliengine.engine.objects;

import com.manelliengine.engine.game.Game;
import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Vector2;

public class PreObject extends GameObject {

	public PreObject(Vector2 position, Scale scale, Game game) {
		super(position, scale);
	}
	
	public GameObject getObject() {
		return this;
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void Update() {

	}

	@Override
	public void Render() {

	}

	@Override
	public void onDestroy() {

	}

}
