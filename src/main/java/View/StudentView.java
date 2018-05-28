package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class StudentView extends  JFrame{
    private JPanel panel1;
    private JTable table1;
    private JButton scheduleButton;
    private JButton groupButton;
    private JButton historyButton;

    public StudentView ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Student View");
    }


    public void setScheduleButton(ActionListener a) {
        this.scheduleButton.addActionListener(a);
    }

    public void setGroupButton(ActionListener a ) {
        this.groupButton.addActionListener(a);
    }

    public void setHistoryButton(ActionListener a) {
        this.historyButton.addActionListener(a);
    }

    public void setTable(MouseListener m)
    {
        this.table1.addMouseListener(m);
    }

    public JTable getTable1() {
        return table1;
    }
}
