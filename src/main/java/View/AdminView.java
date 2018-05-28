package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class AdminView extends JFrame{
    private JPanel panel1;
    private JTable studentTable;
    private JTable teacherTable;
    private JTextField studentNameTF;
    private JTextField lectureNameTF;
    private JTextField teacherNameTF;
    private JButton assignButton;
    private JButton studentSetingsButton;
    private JButton teacherSetingsButton;
    private JButton lectureSetingsButton;

    public AdminView ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setName("Admin View");
    }

    public JTable getStudentTable() {
        return studentTable;
    }

    public JTable getTeacherTable() {
        return teacherTable;
    }

    public JTextField getStudentNameTF() {
        return studentNameTF;
    }

    public JTextField getLectureNameTF() {
        return lectureNameTF;
    }

    public JTextField getTeacherNameTF() {
        return teacherNameTF;
    }

    public void setStudentTable(MouseListener m ) {
        this.studentTable.addMouseListener(m);
    }

    public void setTeacherTable(MouseListener m) {
        this.teacherTable.addMouseListener(m);
    }

    public void setAssignButton(ActionListener a) {
        this.assignButton.addActionListener(a);
    }

    public void setStudentSetingsButton(ActionListener a) {
        this.studentSetingsButton.addActionListener(a);
    }

    public void setTeacherSetingsButton(ActionListener a) {
        this.teacherSetingsButton.addActionListener(a);
    }

    public void setLectureSetingsButton(ActionListener a) {
        this.lectureSetingsButton.addActionListener(a);
    }
}
