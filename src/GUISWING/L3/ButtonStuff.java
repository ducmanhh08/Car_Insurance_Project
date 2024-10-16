package GUISWING.L3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStuff extends JFrame implements ActionListener {

    // Create a button and a label
    JButton button;
    JLabel label;

    ButtonStuff() {
        label = new JLabel("clicked");
        label.setBounds(200, 200, 100, 50);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(200, 100, 100, 50);

        // Add ActionListener to the button
        button.addActionListener(this);

        // Set text for the button
        button.setText("I'm a button");

        // Get rid of the border around button text
        button.setFocusable(false);

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Clicked!");
            label.setVisible(true);
        }
    }

}
