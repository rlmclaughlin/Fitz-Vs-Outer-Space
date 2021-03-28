package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements Runnable, KeyListener {
    public static final float gravity = 0.1f;

    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Thread thread;

    public Screen(){
        thread = new Thread(this);
    }

    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            try{
                speedY+=gravity;
                y+=speedY;
                repaint();
                Thread.sleep(20);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.black);
        graphics.drawRect((int) x, (int) y, 100, 100);


    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        speedY = -4;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}
