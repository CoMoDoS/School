package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class LectureSettings extends JFrame{
    private JTable table1;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField idLectureTF;
    private JTextField teacherTF;
    private JTextField studentTF;
    private JTextField nameLectureTF;
    private JTextField gradeTF;
    private JPanel panel1;

    public LectureSettings ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Lecture Settings");
    }

    public JTable getTable1() {
        return table1;
    }

    public JTextField getIdLectureTF() {
        return idLectureTF;
    }

    public JTextField getTeacherTF() {
        return teacherTF;
    }

    public JTextField getStudentTF() {
        return studentTF;
    }

    public JTextField getNameLectureTF() {
        return nameLectureTF;
    }

    public JTextField getGradeTF() {
        return gradeTF;
    }

    public void setTable1(MouseListener m) {
        this.table1.addMouseListener(m);
    }

    public void setCreateButton(ActionListener a) {
        this.createButton.addActionListener(a);
    }

    public void setDeleteButton(ActionListener a) {
        this.deleteButton.addActionListener(a);
    }

    public void setUpdateButton(ActionListener a) {
        this.updateButton.addActionListener(a);
    }
}
