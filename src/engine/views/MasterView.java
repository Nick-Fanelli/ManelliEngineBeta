package engine.views;

import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Vector2;
import com.manelliengine.engine.views.View;

import engine.objects.Player;
import engine.objects.Wall;

public class MasterView extends View {

	private Player player;
	
	@Override
	public void onCreate() {
		new Wall(new Vector2(20, 0), new Scale(10, 60));
		new Wall(new Vector2(20, 60), new Scale(60, 10));
		player = new Player(new Vector2(0, 0), new Scale(10, 10));
		player.setTag("Player");
	}

	@Override
	public void Update() {
		
	}

	@Override
	public void onDestroy() {
		
	}

}
