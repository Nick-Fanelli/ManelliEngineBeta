package com.manelliengine.engine.gfx;

import java.awt.Color;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.Input;
import com.manelliengine.engine.graphics.Renderer;
import com.manelliengine.engine.math.Transform;

public abstract class Button {
	
	public Transform transform;
	private boolean isPressed = false;
	private boolean isHovering = false;
	private static Renderer r;
	private int color = Color.white.getRGB();
	private int hoveredColor = Color.pink.getRGB();
	private int clickedColor = Color.red.getRGB();
	private int finalColor = color;
	private static Input input;
	
	public Button(Transform transform) {
		this.transform = transform;
	}
	
	public static void setVariables(Game game) {
		r = game.getRenderer();
		input = game.getInput();
	}
	
	public void draw() {
		r.fillRect(transform, finalColor);
	}
	
	public void update() {
		
		float x = transform.position.x;
		float y = transform.position.y;
		float w = transform.scale.width;
		float h = transform.scale.height;
		
		if(input.getMouseX() >= x && input.getMouseX() <= x + w
				&& input.getMouseY() >= y && input.getMouseY()
				<= y + h) {
			isHovering = true;
			finalColor = hoveredColor;
		} else {
			isHovering = false;
			finalColor = color;
			
		}
		
		if(input.getMouseX() >= x && input.getMouseX() <= x + w
				&& input.getMouseY() >= y && input.getMouseY()
				<= y + h && input.isButton(1)) {
			isPressed = true;
			finalColor = clickedColor;
			OnClick();
		} else {
			isPressed = false;
		}
		
	}
	
	public abstract void onCreate();
	public abstract void OnClick();
	public abstract void onDestory();

	public boolean isPressed() {
		return isPressed;
	}
	
	public int getColor() {
		return color;
	}
	
	public boolean isHovering() {
		return isHovering;
	}
	
	public void setColor(int color) {
		this.color = color;
	}

	public int getHoveredColor() {
		return hoveredColor;
	}

	public void setHoveredColor(int hoveredColor) {
		this.hoveredColor = hoveredColor;
	}

	public int getClickedColor() {
		return clickedColor;
	}

	public void setClickedColor(int clickedColor) {
		this.clickedColor = clickedColor;
	}
	
	
	
}
