package engine.objects;

import java.awt.Color;

import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Vector2;
import com.manelliengine.engine.objects.GameObject;

public class Wall extends GameObject {

	public Wall(Vector2 position, Scale scale) {
		super(position, scale);
	}

	@Override
	public void onCreate() {
		super.setTag("Wall");
	}

	@Override
	public void Update() {

	}

	@Override
	public void Render() {
		r.fillRect(this, Color.CYAN);
	}

	@Override
	public void onDestroy() {

	}

}
