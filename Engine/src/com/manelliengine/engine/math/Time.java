package com.manelliengine.engine.math;

import com.manelliengine.engine.Game;

public class Time {

	public static float deltaTime = 0;
	
	public static void updateDt(Game game) {
		deltaTime = game.getDeltaTime();
	}
}
