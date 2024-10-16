package GUISWING.L4;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //    flowlayout = places component in a row sized at their preferred suze if horizontal space in the containr is too small the flow layour class uses the next available row

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); //center, leading , trailing , set spacing between elements horizontal spacing and verticle spacing
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

        panel.add( new JButton("1"));
        panel.add( new JButton("2"));
        panel.add( new JButton("3"));
        panel.add( new JButton("4"));
        panel.add( new JButton("5"));
        panel.add( new JButton("6"));
        panel.add( new JButton("7"));
        panel.add( new JButton("8"));
        panel.add( new JButton("9"));

        frame.add(panel);
        frame.setVisible(true);

    }
}
