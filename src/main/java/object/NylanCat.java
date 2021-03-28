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
        } else {
            speedY += gravity;
            y += speedY;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawRect((int) x, (int) y, animateCat.getFrame().getWidth(), animateCat.getFrame().getHeight());
        g.drawImage(animateCat.getFrame(), (int) x, (int) y, null);
    }

    public void jump(){
        speedY = -4;
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
