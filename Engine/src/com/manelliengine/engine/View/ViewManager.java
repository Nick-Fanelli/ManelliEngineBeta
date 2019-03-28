package com.manelliengine.engine.View;

import com.manelliengine.engine.Game;

public class ViewManager {

    private View activeView;

    public View getActiveView() {
        return activeView;
    }

    public void setActiveView(View activeView) {
        this.activeView = activeView;
    }
}
