package engine.objects;

import java.awt.Color;

import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.objects.GameObject;
import com.manelliengine.engine.physics.playermovement.PlayerMovement;

public class Player extends GameObject {

	public Player(Transform transform) {
		super(transform);
	}

	@Override
	public void Render() {
		r.fillRect(transform, Color.green.getRGB());
	}

	@Override
	public void Update() {
		PhysicsEngine.PlayerMovement.MoveObject(this, PlayerMovement.Style.BOTH);
	}

	@Override
	public void onCreate() {
		
	}

	@Override
	public void onDestory() {
		
	}

}
