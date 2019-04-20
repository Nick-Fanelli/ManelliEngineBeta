package com.manelliengine.engine.physics;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.physics.playermovement.PlayerMovement;

public class PhysicsEngine {

	public Collision Collision;
	public PlayerMovement PlayerMovement;
	 
	public PhysicsEngine(Game game) {
		Collision = new Collision();
		PlayerMovement = new PlayerMovement(game);
	}
	
}
