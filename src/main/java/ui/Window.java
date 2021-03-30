package ui;

import javax.swing.*;

public class Window extends JFrame {

    private Screen screen;

    public Window(){
        super("Fitz VS Outer Space!");
        setSize(700, 339);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = new Screen();
        add(screen);
        addKeyListener(screen);
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
