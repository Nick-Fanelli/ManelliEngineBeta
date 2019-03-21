package com.manelliengine.engine.views;

public class ViewManager {

	private static View activeView = null;
	
	public static void setActiveView(View view) {
		if(activeView != null) {
			onDestroy();
		}
		activeView = view;
		onCreate();
	}
	
	public static void onCreate() {
		activeView.onCreate();
	}
	
	public static void onDestroy() {
		activeView.onDestroy();
	}
	
	public static void update() {
		activeView.Update();
	}
	
}
