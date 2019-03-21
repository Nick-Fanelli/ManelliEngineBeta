package com.manelliengine.engine.collision;

import com.manelliengine.engine.objects.GameObject;

public class CollisionManager {
	
	public static boolean collision(GameObject object1, GameObject object2) {
		boolean state = false;
		if(!state) {state = topSide    (object1, object2);}
		if(!state) {state = bottomSide (object1, object2);}
		return state;
	}
	
	public static boolean rightSide(GameObject object1, GameObject object2) {
		boolean state = false;
		if(!state) {state = topRightCorner    (object1, object2);}
		if(!state) {state = bottomRightCorner (object1, object2);}
		return state;
	}
	
	public static boolean leftSide(GameObject object1, GameObject object2) {
		boolean state = false;
		if(!state) {state = topLeftCorner    (object1, object2);}
		if(!state) {state = bottomLeftCorner (object1, object2);}
		return state;
	}
	
	// Bottom Side Working
	public static boolean bottomSide(GameObject object1, GameObject object2) {
		boolean state = false;
		if(!state) {state = bottomLeftCorner  (object1, object2);}
		if(!state) {state = bottomRightCorner (object1, object2);}
		return state;
	}
	public static boolean bottomLeftCorner(GameObject object1, GameObject object2) {
		boolean state = false;
		if(object1.transform.position.y + object1.transform.scale.height >= object2.transform.position.y) {
			if(!(object1.transform.position.y + object1.transform.scale.height > object2.transform.position.y + object2.transform.scale.height)) {
				if(!(object1.transform.position.x < object2.transform.position.x)) {
					if(!(object1.transform.position.x > object2.transform.position.x + object2.transform.scale.width)) {
						state = true;
					}
				}
			}
		}
		return state;
	}
	public static boolean bottomRightCorner(GameObject object1, GameObject object2) {
		boolean state = false;
		if(object1.transform.position.y + object1.transform.scale.height >= object2.transform.position.y) {
			if(!(object1.transform.position.y + object1.transform.scale.height > object2.transform.position.y + object2.transform.scale.height)) {
				if(!(object1.transform.position.x + object1.transform.scale.width < object2.transform.position.x)) {
					if(!(object1.transform.position.x + object1.transform.scale.width > object2.transform.position.x + object2.transform.scale.width)) {
						state = true;
					}
				}
			}
		}
		return state;
	}
	
	// Top Side Working
	public static boolean topSide(GameObject object1, GameObject object2) {
		boolean state = false;
		if(!state) {state = topLeftCorner  (object1, object2);}
		if(!state) {state = topRightCorner (object1, object2);}
		return state;
	}
	public static boolean topLeftCorner(GameObject object1, GameObject object2) {
		boolean state = false;
		if(object1.transform.position.y <= object2.transform.position.y + object2.transform.scale.height) {
			if(!(object1.transform.position.y < object2.transform.position.y)) {
				if(!(object1.transform.position.x < object2.transform.position.x)) {
					if(!(object1.transform.position.x > object2.transform.position.x + object2.transform.scale.width)) {
						state = true;
					}
				}
			}
		}
		return state;
	}
	public static boolean topRightCorner(GameObject object1, GameObject object2) {
		boolean state = false;
		if(object1.transform.position.y >= object2.transform.position.y) {
			if(object1.transform.position.x + object1.transform.scale.width >= object2.transform.position.x) {
				if(!(object1.transform.position.x + object1.transform.scale.width > object2.transform.position.x + object2.transform.scale.width)) {
					if(!(object1.transform.position.y > object2.transform.position.y + object2.transform.scale.height)) {
						state = true;
					}
				}
			}
		}
 		return state;
	}

}
