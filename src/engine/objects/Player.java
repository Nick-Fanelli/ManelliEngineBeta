package engine.objects;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Vector2;
import com.manelliengine.engine.objects.GameObject;
import com.manelliengine.engine.objects.ObjectManager;

public class Player extends GameObject {
	
	private Color color;

	public Player(Vector2 position, Scale scale) {
		super(position, scale);
	}

	@Override
	public void onCreate() {
		color = Color.YELLOW;
	}

	@Override
	public void Update() {
		System.out.println(ObjectManager.getObjectTags());
		if(super.CollisionWithObject("Wall")) {
			color = Color.RED;
		} else {
			color = Color.YELLOW;
		}
		
		if(Input.isKey(KeyEvent.VK_D)) {transform.position.x++;}
		if(Input.isKey(KeyEvent.VK_A)) {transform.position.x--;}
		if(Input.isKey(KeyEvent.VK_S)) {transform.position.y++;}
		if(Input.isKey(KeyEvent.VK_W)) {transform.position.y--;}
	}

	@Override
	public void Render() {
		r.fillRect(this, color);
	}

	@Override
	public void onDestroy() {
		
	}

}
