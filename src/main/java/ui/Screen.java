package ui;

import object.NylanCat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements Runnable, KeyListener {

    public static final float gravity = 0.1f;
    public static final float ground = 300;

    private NylanCat nylanCat;

    private Thread thread;

    public Screen(){
        thread = new Thread(this);
        nylanCat = new NylanCat();
    }

    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            try{
                nylanCat.update();
                repaint();
                Thread.sleep(20);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics graphics){
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.black);
        graphics.drawLine(0, (int)ground, getWidth(), (int)ground);
        nylanCat.draw(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        nylanCat.jump();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}
