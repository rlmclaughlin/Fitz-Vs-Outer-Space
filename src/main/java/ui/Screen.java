package ui;

import object.MoonSurface;
import object.NylanCat;
import object.ObstacleManager;
import util.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Screen extends JPanel implements Runnable, KeyListener {

    public static final int INTRO_STATE = 0;
    public static final int PLAY_STATE = 1;
    public static final int GAME_OVER = 2;
    public static final int INFO_STATE = 3;

    public static final float gravity = 0.1f;
    public static final float ground = 288;

    private final NylanCat nylanCat;
    private final Thread thread;
    private final MoonSurface moonSurface;
    private final ObstacleManager obstacleManager;

    private int score;
    private int lives = 3;
    private int gameState = INTRO_STATE;

    private final BufferedImage gameOverText;
    private final BufferedImage instructions;
    private final BufferedImage instructionsBackground;

    public Screen(){
        thread = new Thread(this);
        nylanCat = new NylanCat();
        nylanCat.setX(45);
        moonSurface = new MoonSurface();
        obstacleManager = new ObstacleManager(nylanCat, this);
        gameOverText = Resource.getResourceImage("data/fitz-lost.png");
        instructions = Resource.getResourceImage("data/instructions.png");
        instructionsBackground = Resource.getResourceImage("data/menu-screen.png");
    }

    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            try{
                update();
                repaint();
                Thread.sleep(12);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if (gameState == PLAY_STATE) {
            nylanCat.update();
            moonSurface.update();
            obstacleManager.update();
            if (!nylanCat.getIsPlaying()) {
                gameState = GAME_OVER;
            }
        }
    }

    public void incrementScore(int score){
        this.score += score;
    }

    @Override
    public void paint(Graphics graphics){
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.black);
        graphics.drawLine(0, (int)ground, getWidth(), (int)ground);

        switch(gameState){
            case INTRO_STATE:
                nylanCat.draw(graphics);
                moonSurface.draw(graphics);
                graphics.drawImage(Resource.getResourceImage("data/fitz-vs-outerspace.png"), 200, 50, null);
                graphics.setColor(Color.GREEN);
                graphics.drawString("[ i ] How To Play", 30, 30);
                graphics.drawString("[ Space Bar ] Start", 550, 30);
                break;
            case PLAY_STATE:
                moonSurface.draw(graphics);
                nylanCat.draw(graphics);
                obstacleManager.draw(graphics);
                graphics.setColor(Color.GREEN);
                graphics.drawString("Lives: " + lives, 540, 30);
                graphics.drawString("Score: " + score, 600, 30);
                break;
            case GAME_OVER:
                moonSurface.draw(graphics);
                nylanCat.draw(graphics);
                obstacleManager.draw(graphics);
                graphics.drawImage(gameOverText, 200, 50, null);
                graphics.setColor(Color.GREEN);
                graphics.drawString("Lives: " + lives, 540, 30);
                graphics.drawString("Score: " + score, 600, 30);
                graphics.drawString("[ i ] How To Play", 35, 295);
                graphics.drawString("[ Space Bar ] Start", 540, 295);
                break;
            case INFO_STATE:
                graphics.drawImage(instructionsBackground, 0, 0, null);
                graphics.drawImage(instructions, 0, 0, null);
        }
    }

    private void resetGame(){
        nylanCat.setPlaying(true);
        nylanCat.setX(45);
        nylanCat.setY(0);
        nylanCat.setSpeedY(0);
        obstacleManager.reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Obligated to include method due to being part of awt key listener interface.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Obligated to include method due to being part of awt key listener interface.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if(gameState == INTRO_STATE){
                    gameState = PLAY_STATE;
                } else if(gameState == PLAY_STATE){
                    nylanCat.jump();
                } else if(gameState == GAME_OVER && lives <= 1){
                    gameState = PLAY_STATE;
                    score = 0;
                    lives = 3;
                    resetGame();
                } else if(gameState == INFO_STATE){
                    gameState = INTRO_STATE;
                    if(lives > 0){
                        gameState = PLAY_STATE;
                    }
                } else {
                    lives -= 1;
                    gameState = PLAY_STATE;
                    resetGame();
                }
                break;
            case KeyEvent.VK_I:
                if(gameState == INTRO_STATE) {
                    gameState = INFO_STATE;
                } else if(gameState == GAME_OVER){
                    gameState = INFO_STATE;
                }
        }
    }
}
