package GUISWING.L10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame3 extends JFrame implements ActionListener {

    private JRadioButton pizzaButton;
    private JRadioButton hotDofButton;
    private JRadioButton hambergerButton;

    private ButtonGroup group;

    MyFrame3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

         pizzaButton = new JRadioButton("pizza");
         hotDofButton = new JRadioButton("hotDof");
        hambergerButton = new JRadioButton("hamberger");

         group = new ButtonGroup();

         group.add(pizzaButton);
         group.add(hambergerButton);
         group.add(hotDofButton);

         pizzaButton.addActionListener(this);
        hambergerButton.addActionListener(this);
        hotDofButton.addActionListener(this);


         this.add(pizzaButton);
        this.add(hotDofButton);
        this.add(hambergerButton);

        this.setSize(500,500);
//        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pizzaButton){
            System.out.println("pizza for lunch");
        } else if (e.getSource() == hotDofButton) {
            System.out.println("hotDof for lunch");
        }else {
            System.out.println("hamberger");
        }
    }
}
