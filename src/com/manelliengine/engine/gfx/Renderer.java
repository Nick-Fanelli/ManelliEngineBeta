package com.manelliengine.engine.gfx;

import java.awt.Color;
import java.awt.image.DataBufferInt;

import com.manelliengine.engine.game.Game;
import com.manelliengine.engine.objects.GameObject;

public class Renderer {

	private int pW, pH;
	private int[] p;
	
	public Renderer(Game game) {
		pW = game.getWidth();
		pH = game.getHeight();
		p = ((DataBufferInt) game.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear() {
		for(int i = 0; i < p.length; i++) {
			p[i] = 0;
		}
	}
	
	public void setPixel(int x, int y, int value) {
		int alpha = ((value >> 24) & 0xff);
		
		if((x < 0 || x >= pW || y < 0 || y >= pH) || alpha == 0) {
			return;
		}
		
		p[x + y * pW] = value;
	}
	
	public void drawImage(Image image, int offX, int offY) {
			
		// Don't Render Code
		if(offX < -image.getW()) return;
		if(offY < -image.getH()) return;
		if(offX <= -pW      ) return;
		if(offY <= -pH      ) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getW();
		int newHeight = image.getH();
	
		// Clipping Code
		if(offX < 0) {newX -= offX;}
		if(offY < 0) {newY -= offY;}
		if(newWidth  + offX >= pW) {newWidth  -= newWidth  + offX - pW;}
		if(newHeight + offY >= pH) {newHeight -= newHeight + offY - pH;}
		
		for(int y = newY; y < newHeight; y++){
			for(int x = newX; x < newWidth; x++) {
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}
	
	public void fillRect(GameObject object, Color color) {
		int width = object.transform.scale.width;
		int height = object.transform.scale.height;
		int intColor = color.hashCode();
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				setPixel(x + object.transform.position.x, y + object.transform.position.y, intColor);
			}
		}
	}
	
	public void fillRect(GameObject object, int color) {
		int width = object.transform.scale.width;
		int height = object.transform.scale.height;
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				setPixel(x + object.transform.position.x, y + object.transform.position.y, color);
			}
		}
	}

	public int getpH() {
		return pH;
	}

	public int[] getP() {
		return p;
	}

	public int getpW() {
		return pW;
	}
	
}
