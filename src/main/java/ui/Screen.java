package ui;

import javax.swing.*;

public class Screen extends JPanel implements Runnable {

    private int i = 0;
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
            System.out.println("updates/ticks: " + i++);
        }
    }
}
