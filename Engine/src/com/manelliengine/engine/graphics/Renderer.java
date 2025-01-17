package com.manelliengine.engine.graphics;

import java.awt.Color;
import java.awt.image.DataBufferInt;

import com.manelliengine.engine.Game;
import com.manelliengine.engine.gfx.Image;
import com.manelliengine.engine.math.Transform;

public class Renderer {

    private int[] p;
    private int pW, pH;

    private int backgroundcolor;

    public Renderer(Game game) {
        backgroundcolor = 0xff000000;

        pW = game.getWidth();
        pH = game.getHeight();
        p = ((DataBufferInt) game.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void setBackgroundColor(Color color) {
        this.backgroundcolor = color.getRGB();
    }
    public void setBackgroundColor(int color)  {this.backgroundcolor = color;}

    public void setPixel(int x, int y, int value) {
        int alpha = ((value >> 24) & 0xff);

        if((x < 0 || x >= pW || y < 0 || y >= pH) || alpha == 0) {
            return;
        }

        int index = x + y * pW;

        if(alpha == 255) {
            p[index] = value;
        } else {
            int pixelColor = p[index];

            int newRed = ((pixelColor >> 16) & 0xff) - (int) ((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
            int newGreen = ((pixelColor >> 8) & 0xff) - (int) ((((pixelColor >> 8) & 0xff) - ((value >> 8) & 0xff)) * (alpha / 255f));
            int newBlue = (pixelColor & 0xff) - (int) (((pixelColor  & 0xff) - (value & 0xff)) * (alpha / 255f));

            p[x + y * pW] = (255 << 24 | newRed << 16 | newGreen << 8 | newBlue);
        }
    }

    public void clear() {
        for (int i = 0; i < p.length; i++) {
            p[i] = backgroundcolor;
        }
    }

    @SuppressWarnings("unused")
	public void fillRect(Transform transform, int color) {
    	
    	// Don't Render Code
		if(transform.position.x < -transform.scale.width) return;
		if(transform.position.y < -transform.scale.height) return;
		if(transform.position.x <= -pW      ) return;
		if(transform.position.y <= -pH      ) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth  = transform.scale.width;
		int newHeight = transform.scale.height;

		// Clipping Code
		if(transform.position.x < 0) {newX -= transform.position.x;}
		if(transform.position.y < 0) {newY -= transform.position.y;}
		if(newWidth  + transform.position.x >= pW) {newWidth  -= newWidth  + transform.position.x - pW;}
		if(newHeight + transform.position.y >= pH) {newHeight -= newHeight + transform.position.y - pH;}
		
        for(int x = 0; x < transform.scale.width; x++) {
            for(int y = 0; y < transform.scale.height; y++) {
                setPixel(transform.position.x + x, transform.position.y + y, color);
            }
        }
    }
    
    public void drawRect(Transform transform, int color) {
    	for(int y = 0; y <= transform.scale.height; y++) {
    		setPixel(transform.position.x, y + transform.position.y, color);
    		setPixel(transform.position.x + transform.scale.width, y + transform.position.y, color);
    	}
    	for(int x = 0; x <= transform.scale.width; x++) {
    		setPixel(transform.position.x + x, transform.position.y, color);
    		setPixel(transform.position.x + x, transform.scale.height + transform.position.y, color);
    	}
    }
    
    public void drawImage(Image image, int offX, int offY) {
    	for(int y = 0; y < image.getH(); y++) {
    		for(int x = 0; x < image.getW(); x++) {
    			setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
    		}
    	}
    }

}
