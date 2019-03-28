package game.engine;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.GameManager;

public class Manager extends GameManager {

    @Override
    public void StartGame() {
        new Game(this);
    }

    @Override
    public void Init() {

    }

}
