package object;
import util.Animation;
import util.Resource;

import java.awt.*;

import static ui.Screen.gravity;
import static ui.Screen.ground;

public class NylanCat {
    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private final Animation animateCat;
    private final Rectangle rectangle;
    private boolean isPlaying = true;

    public NylanCat(){
        animateCat = new Animation(200);
        animateCat.addFrame(Resource.getResourceImage("data/orange-cat1.png"));
        animateCat.addFrame(Resource.getResourceImage("data/orange-cat2.png"));
        rectangle = new Rectangle();
    }

    public void update(){
        animateCat.update();
        if(y >= ground - animateCat.getFrame().getHeight()){
            speedY = 0;
            y = ground - animateCat.getFrame().getHeight();
            bounce();
        } else if(getY() < -27){
            speedY = -10;
            y += speedY;
            leaveOrbit();
        } else {
            speedY += gravity;
            y += speedY;
        }

        rectangle.x = (int) x;
        rectangle.y = (int) y;
        rectangle.width = animateCat.getFrame().getWidth();
        rectangle.height = animateCat.getFrame().getHeight();
    }

    public Rectangle getBound(){
        return rectangle;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawImage(animateCat.getFrame(), (int) x, (int) y, null);
    }

    public void jump(){
        speedY = -4;
        y += speedY;
    }

    public void bounce(){
        speedY = -2;
        y += speedY;
    }

    public void leaveOrbit(){
        speedY = -10;
        y += speedY;
        setPlaying(false);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setPlaying(boolean active){
        isPlaying = active;
    }

    public boolean getIsPlaying(){
        return isPlaying;
    }
}
