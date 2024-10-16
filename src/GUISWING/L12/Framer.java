package GUISWING.L12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Framer extends JFrame implements ActionListener {

    private JMenuItem loadItem;
    private JMenuItem saveItem;

    private JMenuBar menuBar;

    private JMenu fileMenu;

    private JMenu editMenu;
    private JMenu helpMenu;
    Framer() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500, 500);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("file");
        editMenu= new JMenu("edit");
        helpMenu = new JMenu("help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("save");


        loadItem.addActionListener(this);
        saveItem.addActionListener(this);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem){
            System.out.println("load file");
        }
    }
}
