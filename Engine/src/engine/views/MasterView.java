package engine.views;

import com.manelliengine.engine.math.Position;
import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.view.View;

import engine.gui.StartButton;
import engine.objects.Enemy;
import engine.objects.Player;

public class MasterView extends View {

	private StartButton startButton;
	
	@Override
	public void onCreate() {
		startButton = new StartButton(new Transform(new Position(40, 40), new Scale(100, 25)));
		
		super.CreateButton(startButton);
		super.CreateGameObject(new Enemy(new Transform(new Position(100, 100), new Scale(16, 16))), "Enemy");
		super.CreateGameObject(new Player(new Transform(new Position(0, 0), new Scale(16, 16))), "Player");
	}

	@Override
	public void Update() {
		if(PhysicsEngine.Collision.CollisionWithObject("Player", "Enemy")) {
			super.MoveGameObject("Player", new Position(0, 0));
		}
	}

	@Override
	public void Render() {
		
	}

	@Override
	public void onDestory() {
		
	}
	
}
