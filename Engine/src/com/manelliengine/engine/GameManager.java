package com.manelliengine.engine;

import com.manelliengine.engine.View.View;
import com.manelliengine.engine.View.ViewManager;

public abstract class GameManager {

    public abstract void StartGame();
    public abstract void Init();

    public void setActiveView(View view) {
        new ViewManager().setActiveView(view);
    }

}
