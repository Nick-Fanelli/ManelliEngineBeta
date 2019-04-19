package game.engine.objects;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.objects.GameObject;

public class Player extends GameObject {
	
	public Player(Transform transform) {
		super(transform);
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void Update() {
		if(input.isKey(KeyEvent.VK_W)) {
			transform.position.y--;
		}
		if(input.isKey(KeyEvent.VK_S)) {
			transform.position.y++;
		}
		if(input.isKey(KeyEvent.VK_A)) {
			transform.position.x--;
		}
		if(input.isKey(KeyEvent.VK_D)) {
			transform.position.x++;
		} 
	}

	@Override
	public void Render() {
		if(!PhysicsEngine.Collision.CollisionWithObject("Player", "Enemy")) {
			r.fillRect(transform, Color.green.getRGB());
		} else {
			r.fillRect(transform, Color.red.getRGB());
		}
	}

	@Override
	public void onDestory() {
		
	}

}
