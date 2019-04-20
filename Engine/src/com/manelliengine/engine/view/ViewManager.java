package com.manelliengine.engine.view;

import java.util.ArrayList;
import java.util.HashMap;

import com.manelliengine.engine.objects.GameObject;

public class ViewManager {

    private static View activeView = null;
    private static HashMap<String, GameObject> objects = new HashMap<String, GameObject>();
    private static ArrayList<GameObject> objectsArray = new ArrayList<GameObject>();
    
    public static View getActiveView() {
        return activeView;
    }
    
    public static void createGameObject(GameObject object, String tag) {
    	if(objects.containsKey(tag)) { 
    		System.err.println("Cannot Create Object With The Same Tag As Another : " + tag);
    		return;
    	} else if(objects.containsValue(object)) {
    		System.err.println("Cannot Re-Create Already Created Objcect " + object.getClass().toString());
    		return;
    	}
    	objects.put(tag, object);
    	objectsArray.add(object);
    	object.onCreate();
    }
    
    public void setActiveView(View activeView) {
    	if(ViewManager.activeView != null) {
    		ViewManager.activeView.onDestory();
    	}
        ViewManager.activeView = activeView;
        activeView.onCreate();
    }
    
    public static void destroyGameObject(String tag) {
    	if(objects.containsValue(objects.get(tag))) {
    		objectsArray.remove(objects.get(tag));
    		objects.remove(tag);
    	} else {
    		System.err.println("Object does not already exist");
    		return;
    	}
    }
    
    public static ArrayList<GameObject> getGameObjectsAsArrayList() {
    	return objectsArray;
    }
    
    public static HashMap<String, GameObject> getObjects() {
    	return objects;
    }
}
