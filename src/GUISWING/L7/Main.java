package GUISWING.L7;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        JOptionPane = pop up a standard dialog box that prompts users for a value or informs them of something

        JOptionPane.showMessageDialog(null, "This is some useless info","title",JOptionPane.PLAIN_MESSAGE); //parentComponent, message, title, messageType
        JOptionPane.showMessageDialog(null, "Here is more useless info","title",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is some useless info","title",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is some useless info","title",JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is some useless info","title",JOptionPane.ERROR_MESSAGE);


        System.out.println(JOptionPane.showConfirmDialog(null,"bro do you like puss","this is title",JOptionPane.YES_NO_CANCEL_OPTION));//parentComponent, message, title, messageType

        String name = JOptionPane.showInputDialog("what is ur name");
        System.out.println(name);

        String[] responses = {"No, You are awesome!","Thank you","* blush"};
        JOptionPane.showOptionDialog(null,"You are good","secret msg",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,responses,0);
    }
}

