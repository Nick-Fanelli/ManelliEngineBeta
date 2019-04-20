package com.manelliengine.engine.physics.playermovement;

import java.awt.event.KeyEvent;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.Input;
import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.objects.GameObject;

public class PlayerMovement {

	private Input input;
	
	public enum Style {
		ARROWS, WASD, BOTH
	}
	
	public PlayerMovement(Game game) {
		input = game.getInput();
	}
	
	public void MoveObject(GameObject gameObject, Style style) {
		
		Transform transform = gameObject.transform;
		
		switch (style) {
		
		case ARROWS:
			MoveObjectUsingArrows (transform);
			break;
		case WASD:
			MoveObjectUsingWASD   (transform);
			break;
		case BOTH:
			MoveObjectUsingWASD   (transform);
			MoveObjectUsingArrows (transform);
			break;
		
		}
	}
	
	private void MoveObjectUsingArrows(Transform transform) {
		if(input.isKey(KeyEvent.VK_LEFT)) {
			transform.position.x--;
		}
		if(input.isKey(KeyEvent.VK_RIGHT)) {
			transform.position.x++;
		}
		if(input.isKey(KeyEvent.VK_UP)) {
			transform.position.y--;
		}
		if(input.isKey(KeyEvent.VK_DOWN)) {
			transform.position.y++;
		}
	}
	
	private void MoveObjectUsingWASD(Transform transform) {
		if(input.isKey(KeyEvent.VK_A)) {
			transform.position.x--;
		}
		if(input.isKey(KeyEvent.VK_D)) {
			transform.position.x++;
		}
		if(input.isKey(KeyEvent.VK_W)) {
			transform.position.y--;
		}
		if(input.isKey(KeyEvent.VK_S)) {
			transform.position.y++;
		}
	}

}
