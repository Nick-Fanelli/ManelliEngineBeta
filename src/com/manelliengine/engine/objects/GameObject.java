package com.manelliengine.engine.objects;

import com.manelliengine.engine.Error;
import com.manelliengine.engine.ExitCode;
import com.manelliengine.engine.Input;
import com.manelliengine.engine.collision.CollisionManager;
import com.manelliengine.engine.game.Game;
import com.manelliengine.engine.gfx.Renderer;
import com.manelliengine.engine.math.Scale;
import com.manelliengine.engine.math.Transform;
import com.manelliengine.engine.math.Vector2;

public abstract class GameObject {

	protected enum Corner {
		TL, TR, BL, BR
	}
	
	protected enum Side {
		TOP, RIGHT, LEFT, BOTTOM
	}
	
	public Transform transform;
	private String tag;
	
	protected static Input Input;
	protected static Renderer r;
	
	public static void ListCurrentObjects() {
		new ObjectManager().ListCurrentObjects();
	}
	
	public void init(Game game) {
		tag = "";
		GameObject.r = game.getRenderer();
		GameObject.Input = game.getInput();
	}
	
	public static void RemoveGameObject(GameObject object) {
		if(!ObjectManager.getObjects().contains(object)) {
			Error.error(object + " Does Not Exist");
			Error.exit(ExitCode.ObjectDoesNotExist);
		}
		ObjectManager.removeGameObject(object);
	}
	
	public static void ReAttachGameObject(GameObject object) {
		if(ObjectManager.getObjects().contains(object)) {
			Error.error(object + " Already Exists");
			Error.exit(ExitCode.ObjectAlreadyExists);
		}
		ObjectManager.addGameObject(object);
	}
	
	public GameObject(Vector2 position, Scale scale) {
		transform = new Transform(position, scale);
		start();
	}
	
	public boolean CollisionWithObject(GameObject object) {
		return CollisionManager.collision(this, object);
	}
	
	public boolean CollisionWithObject(String tag) {
		return CollisionManager.collision(this, ObjectManager.getObjectTags().get(tag));
	}
	
	public boolean CollisionWithSide(Side side, GameObject object) {
		switch(side) {
		case LEFT:
			return CollisionManager.leftSide(this, object);
		case RIGHT:
			return CollisionManager.rightSide(this, object);
		case BOTTOM:
			return CollisionManager.bottomSide(this, object);
		case TOP:
			return CollisionManager.topSide(this, object);
		}
		return false;
	}
	
	public boolean CollisionWithSide(Side side, String tag) {
		GameObject object = ObjectManager.getObjectTags().get(tag);
		switch(side) {
		case LEFT:
			return CollisionManager.leftSide(this, object);
		case RIGHT:
			return CollisionManager.rightSide(this, object);
		case BOTTOM:
			return CollisionManager.bottomSide(this, object);
		case TOP:
			return CollisionManager.topSide(this, object);
		}
		return false;
	}
	
	public boolean CollisionWithCorner(Corner corner, GameObject object) {
		switch(corner) {
		case TL:
			return CollisionManager.topLeftCorner(this, object);
		case TR:
			return CollisionManager.topRightCorner(this, object);
		case BL:
			return CollisionManager.bottomLeftCorner(this, object);
		case BR:
			return CollisionManager.bottomRightCorner(this, object);
		}
		return false;
	}
	
	public boolean CollisionWithCorner(Corner corner, String tag) {
		GameObject object = ObjectManager.getObjectTags().get(tag);
		switch(corner) {
		case TL:
			return CollisionManager.topLeftCorner(this, object);
		case TR:
			return CollisionManager.topRightCorner(this, object);
		case BL:
			return CollisionManager.bottomLeftCorner(this, object);
		case BR:
			return CollisionManager.bottomRightCorner(this, object);
		}
		return false;
	}
	
	public void start() {
		ObjectManager.addGameObject(this);
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
		ObjectManager.setTag(this, tag);
	}
	
	public abstract void onCreate();
	public abstract void Update();
	public abstract void Render();
	public abstract void onDestroy();
	
}
