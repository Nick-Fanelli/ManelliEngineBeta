package com.manelliengine.engine.physics;

import com.manelliengine.engine.View.ViewManager;
import com.manelliengine.engine.objects.GameObject;

public class Collision {
	
	public void test() {
		System.out.println("Working");
	}
	
	private boolean CWO(GameObject object1, GameObject object2) {
		
		boolean state = false; 
		if(!state) {state = TopSide(object1, object2);}
		if(!state) {state = BottomSide(object1, object2);}
		return state;
	}
	
	public boolean CollisionWithObject(String object1Tag, String object2Tag) {
		
		GameObject gameObject1 = ViewManager.getObjects().get(object1Tag);
		GameObject gameObject2 = ViewManager.getObjects().get(object2Tag);
		
		boolean state = false; 
		if(!state) {state = TopSide(gameObject1, gameObject2);}
		if(!state) {state = BottomSide(gameObject1, gameObject2);}
		if(!state) {state = CWO(gameObject2, gameObject1);}
		return state;
	}
	
	public boolean TopSide(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		state = TopRightCorner(gameObject1, gameObject2);
		if(!state) {state = TopLeftCorner(gameObject1, gameObject2);}
		return state;
	} 
	
	public boolean BottomSide(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		state = BottomRightCorner(gameObject1, gameObject2);
		if(!state) {state = BottomLeftCorner(gameObject1, gameObject2);}
		return state;
	}
	
	public boolean RightSide(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		state = TopRightCorner(gameObject1, gameObject2);
		if(!state) {state = BottomRightCorner(gameObject1, gameObject2);}
		return state;
	}
	
	public boolean LeftSide(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		state = BottomLeftCorner(gameObject1, gameObject2);
		if(!state) {state = TopLeftCorner(gameObject1, gameObject2);}
		return state;
	}
	
	private boolean TopLeftCorner(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		
		float x1 = gameObject1.transform.position.x;
		float y1 = gameObject1.transform.position.y;
		
		float x2 = gameObject2.transform.position.x;
		float y2 = gameObject2.transform.position.y;
		float w2 = gameObject2.transform.scale.width;
		float h2 = gameObject2.transform.scale.height;
		
		if(x1 >= x2 && x1 <= x2 + w2 && y1 >= y2 && y1 <= y2 + h2) {
			state = true;
		}
		
		return state;
	}
	
	private boolean TopRightCorner(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		
		float x1 = gameObject1.transform.position.x;
		float y1 = gameObject1.transform.position.y;
		float w1 = gameObject1.transform.scale.width;
		
		float x2 = gameObject2.transform.position.x;
		float y2 = gameObject2.transform.position.y;
		float w2 = gameObject2.transform.scale.width;
		float h2 = gameObject2.transform.scale.height;
		
		if(x1 + w1 >= x2 && x1 + w1 <= x2 + w2 && y1 >= y2 && y1 <= y2 + h2) {
			state = true;
		}
		
		return state;
	}
	
	private boolean BottomLeftCorner(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		
		float x1 = gameObject1.transform.position.x;
		float y1 = gameObject1.transform.position.y;
		float h1 = gameObject1.transform.scale.height;
		
		float x2 = gameObject2.transform.position.x;
		float y2 = gameObject2.transform.position.y;
		float h2 = gameObject2.transform.scale.height;
		
		if(x1 >= x2 && x1 <= x2 + h2 && y1 + h1 >= y2 && y1 + h1 <= y2 + h2) {
			state = true;
		}
		
		return state;
	}
	
	private boolean BottomRightCorner(GameObject gameObject1, GameObject gameObject2) {
		boolean state = false;
		
		float x1 = gameObject1.transform.position.x;
		float y1 = gameObject1.transform.position.y;
		float w1 = gameObject1.transform.scale.width;
		float h1 = gameObject1.transform.scale.height;
		
		float x2 = gameObject2.transform.position.x;
		float y2 = gameObject2.transform.position.y;
		float w2 = gameObject2.transform.scale.width;
		float h2 = gameObject2.transform.scale.height;
		
		if(x1 + w1 >= x2 && x1 + w1 <= x2 + w2 && y1 + h1 >= y2 && y1 + h1 <= y2 + h2) {
			state = true;
		}
		
		return state;
	}
}
