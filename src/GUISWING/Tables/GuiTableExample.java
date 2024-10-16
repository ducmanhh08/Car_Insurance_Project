package GUISWING.Tables;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiTableExample {

    public static void main(String[] args) {
        // Sample data for the table
        Object[][] data = {
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28}
        };

        // Column names
        String[] columnNames = {"First Name", "Last Name", "Age"};

        // Create the JTable with the data and column names
        JTable table = new JTable(data, columnNames);

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the main JFrame and add the scroll pane to it
        JFrame frame = new JFrame("GUI Table Example");
        frame.add(scrollPane);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}