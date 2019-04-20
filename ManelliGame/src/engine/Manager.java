package engine;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.GameManager;

import engine.views.MasterView;

public class Manager extends GameManager {

	@Override
	public void Init() {
		super.setActiveView(new MasterView());
	}

	@Override
	public void StartGame() {
		new Game(this);
	}

}
