package GUISWING.Tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedExample extends JFrame {
    public TabbedExample() {
        setTitle("Tabbed Pane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        // Create the log out button
        JButton logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform log out actions here
                System.out.println("Logged out");
            }
        });

        // Create the panel to hold the log out button
        JPanel logoutPanel = new JPanel();
        logoutPanel.add(logoutButton);

        // Create the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create the content panels for each tab
        JPanel tab1 = new Tab1Panel();
        JPanel tab2 = new Tab2Panel();
        JPanel tab3 = new Tab3Panel();

        // Add the tabs to the tabbed pane
        tabbedPane.addTab("Tab 1", tab1);
        tabbedPane.addTab("Tab 2", tab2);
        tabbedPane.addTab("Tab 3", tab3);

        // Create a panel to hold the log out button and tabbed pane
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(logoutPanel, BorderLayout.WEST);
        mainPanel.add(tabbedPane, BorderLayout.NORTH);

        // Set preferred size for the tabbed pane
        tabbedPane.setPreferredSize(new Dimension(400, 300));

        // Add the main panel to the frame
        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        // Create an instance of the TabbedExample class
        TabbedExample example = new TabbedExample();

        // Make the frame visible
        example.setVisible(true);
    }
}

class Tab1Panel extends JPanel {
    public Tab1Panel() {
        add(new JLabel("This is Tab 1"));
    }
}

class Tab2Panel extends JPanel {
    public Tab2Panel() {
        add(new JLabel("This is Tab 2"));
    }
}

class Tab3Panel extends JPanel {
    public Tab3Panel() {
        add(new JLabel("This is Tab 3"));
    }
}