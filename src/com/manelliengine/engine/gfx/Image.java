 package com.manelliengine.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import com.manelliengine.engine.Error;
import javax.imageio.ImageIO;


public class Image {
	
	private int w, h;
	private int[] p;
	
	private String path;

	public Image(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(Image.class.getResourceAsStream(path));
		} catch (IOException e) {
			Error.error("Could not find iamge at path of " + path + "!");
			return;
		}
		
		this.path = path;
		w = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0, 0, w, h, null, 0, w);
		
		image.flush();
	}
	
	public Image(int[] p, int w, int h) {
		this.p = p;
		this.h = h;
		this.w = w;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		if(w <= this.w) {
			this.w = w;
		} else {
			try {
				Error.error("Image at " + path + "'s width could not be set to " + w);
			} catch(Exception e) {
				Error.error("The images with could not be set to " + w);
			}
		}
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		if(h <= this.h) {
			this.h = h;
		} else {
			try {
				Error.error("Image at " + path + "'s width could not be set to " + h);
			} catch(Exception e) {
				Error.error("The images with could not be set to " + h);
			}
		}
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}
}
