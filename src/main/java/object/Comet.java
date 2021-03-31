package object;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Comet extends Obstacle {

    private BufferedImage image;
    private int posX, posY;
    private final Rectangle rectangle;
    private final NylanCat nylanCat;
    private boolean isPointsEarned = false;

    public Comet(NylanCat nylanCat){
        this.nylanCat = nylanCat;
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

    @Override
    public Rectangle getBound(){
        return rectangle;
    }

    @Override
    public void draw(Graphics graphics){
        graphics.drawImage(image, posX, posY, null);
    }

    public void setX(int x){
        posX = x;
    }

    public void setY(int y){
        posY = y;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    @Override
    public boolean isOutOfScreen(){
        return (posX + image.getWidth() < 0);
    }

    @Override
    public boolean isOverObstacle() {
        return (nylanCat.getX() > posX);
    }

    @Override
    public boolean isPointsEarned(){
        return isPointsEarned;
    }

    @Override
    public void setPointsEarned(boolean isPointsEarned){
        this.isPointsEarned = isPointsEarned;
    }
}