package object;

import util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UFO {

    private BufferedImage image;
    private int posX, posY;
    private Rectangle rectangle;

    public UFO(){
        image =  Resource.getResourceImage("data/ufo1.png");
        posX = 360;
        posY = 229;
        rectangle = new Rectangle();
    }

    public void update(){
        posX -= 2;
        rectangle.x = posX;
        rectangle.y = posY;
        rectangle.width = image.getWidth();
        rectangle.height = image.getHeight();
    }

    public Rectangle getBound(){
        return rectangle;
    }

    public void draw(Graphics graphics){
        graphics.drawImage(image, posX, posY, null);
    }

}
