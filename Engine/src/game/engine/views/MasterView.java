package game.engine.views;

import com.manelliengine.engine.View.View;
import com.manelliengine.engine.math.Position;
import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Transform;

import game.engine.objects.Enemy;
import game.engine.objects.Player;

public class MasterView extends View {
	
    @Override 
    public void onCreate() {
    	super.CreateGameObject(new Enemy (new Transform(new Position(100, 100), new Scale(10, 10))),  "Enemy");
    	super.CreateGameObject(new Player(new Transform(new Position(0  ,   0), new Scale(16, 16))), "Player");
    }
    
    @Override
    public void Update() {

    }
    
    @Override
    public void Render() {

    }

    @Override
    public void onDestory() {

    }

}
