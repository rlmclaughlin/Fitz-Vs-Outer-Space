package object;

import util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleManager {
    private List<Obstacle>obstacles;
    private Random random;
    private BufferedImage ufoImage1, ufoImage2;
    private NylanCat nylanCat;

    public ObstacleManager(NylanCat nylanCat){
        this.nylanCat = nylanCat;
        obstacles = new ArrayList<>();
        ufoImage1 =  Resource.getResourceImage("data/ufo1.png");
        ufoImage2 =  Resource.getResourceImage("data/comet-1.png");
        random = new Random();
        UFO ufo = new UFO();
        obstacles.add(getRandomUFO());
        random = new Random();

    }

    public void update(){
        for(Obstacle index : obstacles){
            index.update();
            if(index.getBound().intersects(nylanCat.getBound())){
                nylanCat.setPlaying(false);
            }
        }
        Obstacle firstObstacle = obstacles.get(0);
        if(firstObstacle.isOutOfScreen()){
            obstacles.remove(firstObstacle);
            obstacles.add(getRandomUFO());
        }
    }

    public void draw(Graphics graphics){
        for(Obstacle index : obstacles){
            index.draw(graphics);
        }
    }

    private UFO getRandomUFO(){
        UFO ufo = new UFO();
        ufo.setX(701);
        if(random.nextBoolean()){
            ufo.setImage(ufoImage1);
        } else {
            ufo.setImage(ufoImage2);
        }
        return ufo;
    }
}
