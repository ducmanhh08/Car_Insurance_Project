package GUISWING.L1;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        super("something"); //replace for the title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420,420);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("stewie.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(136,236,203));
    }
}
