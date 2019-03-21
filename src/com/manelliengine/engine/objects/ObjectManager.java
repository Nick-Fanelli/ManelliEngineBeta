package com.manelliengine.engine.objects;

import java.util.ArrayList;
import java.util.HashMap;

import com.manelliengine.engine.game.Game;

public class ObjectManager {
	
	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<String> objectNames = new ArrayList<String>();
	private static HashMap<String, GameObject> objectTags = new HashMap<String, GameObject>();
	
	public void init(Game game) {
		objects.remove(game.getPreObject());
		objectNames.remove(game.getPreObject().getClass().getSimpleName());
	}
	
	public void ListCurrentObjects() {
		if(objectNames.isEmpty()) {
			objectNames.add("No Objects In View");
		}
		System.out.println(objectNames.toString());
		objectNames.remove("No Objects In View");
	}
	
	public static void addGameObject(GameObject object) {
		objects.add(object);
		objectNames.add(object.getClass().getSimpleName());
		object.onCreate();
	}
	
	public static void removeGameObject(GameObject object) {
		objects.remove(object);
		objectNames.remove(object.getClass().getSimpleName());
		object.onDestroy();
	}
	
	public static void update() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).Update();
		}
	}
	
	public static void render() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).Render();
		}
	}
	
	public static void setTag(GameObject object, String tag) {
		objectTags.put(tag, object);
	}
	
	public static void cleanUp() {
		objects.clear();
		objectTags.clear();
		objectNames.clear();
	}
	
	public static HashMap<String, GameObject> getObjectTags() {
		return objectTags;
	}
	
	public static ArrayList<GameObject> getObjects() {
		return objects;
	}

}
