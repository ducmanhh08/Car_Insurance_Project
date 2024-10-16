package GUISWING.L9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame implements ActionListener {

    private JButton button;
    private JCheckBox checkBox;
    MyFrame2(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("Im not a robot");
        checkBox.setFocusable(false);

        this.add(button);
        this.add(checkBox);

        this.setSize(500,500);
//        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            Boolean check = checkBox.isSelected();
            if(check){
                System.out.println("not robot");
            }else {
                System.out.println("robot");
            }
        }
    }
}
