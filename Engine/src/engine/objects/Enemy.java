package engine.objects;

import java.awt.Color;

import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.objects.GameObject;

public class Enemy extends GameObject {

	public Enemy(Transform transform) {
		super(transform);
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void Update() {

	}

	@Override
	public void Render() {
		r.fillRect(transform, Color.red.getRGB());
	}

	@Override
	public void onDestory() {

	}

}
