package com.manelliengine.engine.graphics;

import com.manelliengine.engine.Data.Transform;
import com.manelliengine.engine.Game;

import java.awt.*;
import java.awt.image.DataBufferInt;

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

    public void fillRect(Transform transform, int color) {
        for(int x = 0; x < transform.scale.width; x++) {
            for(int y = 0; y < transform.scale.height; y++) {
                setPixel(transform.position.x + x, transform.position.y + y, color);
            }
        }
    }

}
