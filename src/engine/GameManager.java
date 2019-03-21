package engine;

import com.manelliengine.engine.game.Game;
import com.manelliengine.engine.game.Manager;
import com.manelliengine.engine.platform.Platform;

import engine.views.MasterView;

public class GameManager extends Manager {

	private static int width = 320;
	private static int height = 240;
	private static float scale = 3f;
	
	public void start() {
		new Game(this, width, height, scale, Platform.STANDALONE);
	}
	
	@Override
	public void Start() {
		super.SetActiveView(new MasterView());
	}
	
}
