package object;

import ui.Screen;
import util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleManager {
    private final List<Obstacle>obstacles;
    private final Random random;
    private final BufferedImage ufoImage1;
    private final BufferedImage ufoImage2;
    private final BufferedImage cometImage1;
    private final BufferedImage cometImage2;
    private final NylanCat nylanCat;
    private final Screen screen;

    public ObstacleManager(NylanCat nylanCat, Screen screen){
        this.screen = screen;
        this.nylanCat = nylanCat;
        obstacles = new ArrayList<>();

        ufoImage1 =  Resource.getResourceImage("data/ufo1.png");
        ufoImage2 =  Resource.getResourceImage("data/ufo2.png");
        cometImage1 =  Resource.getResourceImage("data/comet-2.png");
        cometImage2 =  Resource.getResourceImage("data/comet-1.png");

        random = new Random();

        obstacles.add(getRandomUFO());
        obstacles.add(getRandomComet());
    }

    public void update(){
        for(Obstacle index : obstacles){
            index.update();
            if(index.isOverObstacle() && !index.isPointsEarned()){
                screen.incrementScore(1);
                index.setPointsEarned(true);
            }
            if(index.getBound().intersects(nylanCat.getBound())){
                nylanCat.setPlaying(false);
            }
        }
        Obstacle firstObstacle = obstacles.get(0);
        if(firstObstacle.isOutOfScreen()){
            obstacles.remove(firstObstacle);
            obstacles.add(getRandomUFO());
            obstacles.add(getRandomComet());
        }
    }

    public void draw(Graphics graphics){
        for(Obstacle index : obstacles){
            index.draw(graphics);
        }
    }

    public void reset(){
        obstacles.clear();
        obstacles.add(getRandomUFO());
        obstacles.add(getRandomComet());
    }

    private UFO getRandomUFO(){
        UFO ufo = new UFO(nylanCat);
        ufo.setX(701);
        if(random.nextBoolean()){
            ufo.setImage(ufoImage1);
            ufo.setX(755);
        } else {
            ufo.setImage(ufoImage2);
        }
        return ufo;
    }

    private Comet getRandomComet(){
        Comet comet = new Comet(nylanCat);
        comet.setX(898);
        comet.setY(20);
        if(random.nextBoolean()){
            comet.setImage(cometImage1);
            comet.setX(955);
        } else {
            comet.setImage(cometImage2);
        }
        return comet;
    }
}


