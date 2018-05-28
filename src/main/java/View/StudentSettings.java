package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class StudentSettings extends JFrame{
    private JPanel panel1;
    private JTable studentTable;
    private JTable lectureTable;
    private JTextField idStudentTF;
    private JTextField statusStudentTF;
    private JTextField passStudentTF;
    private JTextField emailStudentTF;
    private JTextField nameStudentTF;
    private JButton endButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton createButton;
    private JTextField groupStudentTF;
    private JTextField gradeStuentTF;

    public StudentSettings()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Student Settings");
    }

    public JTable getStudentTable() {
        return studentTable;
    }

    public JTable getLectureTable() {
        return lectureTable;
    }

    public JTextField getGroupStudentTF() {
        return groupStudentTF;
    }

    public JTextField getGradeStuentTF() {
        return gradeStuentTF;
    }

    public JTextField getIdStudentTF() {
        return idStudentTF;
    }

    public JTextField getStatusStudentTF() {
        return statusStudentTF;
    }

    public JTextField getPassStudentTF() {
        return passStudentTF;
    }

    public JTextField getEmailStudentTF() {
        return emailStudentTF;
    }

    public JTextField getNameStudentTF() {
        return nameStudentTF;
    }

    public void setStudentTable(MouseListener m ) {
        this.studentTable.addMouseListener(m);
    }

    public void setLectureTable(MouseListener m ) {
        this.lectureTable.addMouseListener(m);
    }

    public void setEndButton(ActionListener a) {
        this.endButton.addActionListener(a);
    }

    public void setDeleteButton(ActionListener a) {
        this.deleteButton.addActionListener(a);
    }

    public void setUpdateButton(ActionListener a) {
        this.updateButton.addActionListener(a);
    }

    public void setCreateButton(ActionListener a) {
        this.createButton.addActionListener(a);
    }
}
