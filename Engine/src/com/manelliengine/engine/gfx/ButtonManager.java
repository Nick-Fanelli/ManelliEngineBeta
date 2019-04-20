package com.manelliengine.engine.gfx;

import java.util.ArrayList;

public class ButtonManager {
	
	private static ArrayList<Button> buttons = new ArrayList<Button>();
	
	public static void createButton(Button button) {
		if(buttons.contains(button)) {
			System.err.println(button.toString() + " instance already exists, create another instance. ex. new Button();");
			return;
		}
		button.onCreate();
		buttons.add(button);
	}
	
	public static void destoryButton(Button button) {
		if(buttons.contains(button)) {
			buttons.remove(button);
			button.onDestory();
		} else {
			System.err.println(button.toString() + " does not exist in the game!");
			return;
		}
	}
	
	public ArrayList<Button> getButtonsInGame() {
		return buttons;
	}

}
