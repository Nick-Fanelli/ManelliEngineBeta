package engine.views;

import com.manelliengine.engine.view.View;
import com.manelliengine.engine.math.Position;
import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Transform;

import engine.objects.Enemy;
import engine.objects.Player;

public class MasterView extends View {

	@Override
	public void Render() {
		
	}

	@Override
	public void Update() {
		if(PhysicsEngine.Collision.CollisionWithObject("Player", "Enemy")) {
			super.DestroyGameObject("Player");
		}
	}

	@Override
	public void onCreate() {
		super.CreateGameObject(new Enemy(new Transform(new Position(100, 100), new Scale(16, 16))), "Enemy");
		super.CreateGameObject(new Player(new Transform(new Position(0, 0), new Scale(16, 16))), "Player");
	}

	@Override
	public void onDestory() {
		
	}

}
