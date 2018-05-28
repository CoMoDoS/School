package View;

import javax.swing.*;

public class Group extends JFrame{
    private JPanel panel1;
    private JTable groupTable;

    public Group ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Group");
    }

    public JTable getGroupTable() {
        return groupTable;
    }
}
