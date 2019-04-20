package com.manelliengine.engine;

import com.manelliengine.engine.view.View;
import com.manelliengine.engine.view.ViewManager;

public abstract class GameManager {

    public abstract void StartGame();
    public abstract void Init();

    public void setActiveView(View view) {
        new ViewManager().setActiveView(view);
    }

}
