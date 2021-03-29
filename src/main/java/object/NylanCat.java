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
    private Animation animateCat;

    public NylanCat(){

        //my cat images
        animateCat = new Animation(200);
        animateCat.addFrame(Resource.getResourceImage("data/greyCat2.png"));
        animateCat.addFrame(Resource.getResourceImage("data/greyCat1.png"));
    }

    public void update(){
        animateCat.update();
        // all this code is responsible for jumping
        if(y >= ground - animateCat.getFrame().getHeight()){
            speedY = 0;
            y = ground - animateCat.getFrame().getHeight();
            bounce();
        } else {
            speedY += gravity;
            y += speedY;
        }

        // signals cat is out of gravity zone, auto lose. Refactor into a function later!!!

        if(getY() < (float) -15.0){
            System.out.println("LOSE");
        }
    }

    public void draw(Graphics g){
        //illustrating cat
        g.setColor(Color.black);
        g.drawImage(animateCat.getFrame(), (int) x, (int) y, null);
    }

    public void jump(){
        speedY = -4;
        y += speedY;
    }


    // routine moon bounce for cat when not pushing jump
    public void bounce(){
        speedY = -2;
        y += speedY;
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
}
