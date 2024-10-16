package GUISWING.L2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        JLabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("D:\\JavaOOP\\src\\GUISWING\\L2\\fk.png");
        Border border = BorderFactory.createLineBorder(Color.black,3);

        JLabel label = new JLabel(); //create a label
        label.setText("Bro, Do you like Puss"); // set text of label
        label.setIcon(image);

//        change our text position
        label.setHorizontalTextPosition(JLabel.CENTER); //left, center or right of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //top, center or bottom

//        change text color
        label.setForeground(Color.green);

//        change font size
        label.setFont(new Font("MV Boli",Font.PLAIN,20));

//        add margin for label and image
        label.setIconTextGap(100);

//        set background color for label
        label.setBackground(Color.red);
        label.setOpaque(true);

//        set border
        label.setBorder(border);

//        set the position coz label like to take everything it could
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JFrame frame = new JFrame();
        frame.setTitle("something");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setVisible(true);

        frame.add(label); // add label to the frame
    }
}
