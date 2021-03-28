package ui;

import javax.swing.*;

public class Window extends JFrame {

    private Screen screen;

    public Window(){
        super("Fitz V.S. Outer Space!");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = new Screen();
        add(screen);
    }

    public void startGame(){
        screen.startGame();
    }

    public static void main(String[] args){
        Window window = new Window();
        window.setVisible(true);
        window.startGame();
    }
}
