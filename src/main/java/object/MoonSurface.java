package object;

import util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MoonSurface {

    private final ArrayList<MoonSurfaceImage> listImage;
    private BufferedImage moonImg1, moonImg2, moonImg3;

    public MoonSurface(){
        moonImg1 = Resource.getResourceImage("data/moon-surface-1.png");
        moonImg2 = Resource.getResourceImage("data/moon-surface-2.png");
        moonImg3 = Resource.getResourceImage("data/moon-surface-3.png");
        listImage = new ArrayList<>();

        for(int i = 0; i < 500; i++){
            MoonSurfaceImage moonSurface = new MoonSurfaceImage();
            moonSurface.posX = (i * moonImg1.getWidth());
            moonSurface.image = moonImg1;
            listImage.add(moonSurface);
        }
    }

    public void update(){
        for(MoonSurfaceImage moonImg : listImage){
            moonImg.posX --;
        }
        if(listImage.get(0).posX + moonImg1.getWidth() < 0) {
            listImage.add(listImage.get(0));
            listImage.remove(0);
        }
    }

    public void draw(Graphics graphics){
        for (MoonSurfaceImage moonSurfaceImage : listImage) {
            graphics.drawImage(moonSurfaceImage.image, moonSurfaceImage.posX, 0, null);
        }
    }

    private static class MoonSurfaceImage{
        int posX;
        BufferedImage image;
    }
}
