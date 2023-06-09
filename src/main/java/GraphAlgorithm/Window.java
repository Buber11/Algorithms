package GraphAlgorithm;

import javax.swing.*;

public class Window extends JFrame {

    public static void main(String[] args) {
        new Window();
    }

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,750);
        setContentPane(new Panel());


        setVisible(true);
    }
}
