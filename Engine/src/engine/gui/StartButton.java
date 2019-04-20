package engine.gui;

import java.awt.Color;

import com.manelliengine.engine.gfx.Button;
import com.manelliengine.engine.math.Transform;

public class StartButton extends Button {

	public StartButton(Transform transform) {
		super(transform);
	}
	
	@Override
	public void onCreate() {
		super.setColor        (Color.white.getRGB());
		super.setHoveredColor (Color.cyan .getRGB());
		super.setClickedColor (Color.blue .getRGB());
	} 

	@Override
	public void OnClick() {
		
	}

	@Override
	public void onDestory() {
		
	}

}
