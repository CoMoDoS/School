package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TeacherView extends JFrame{
    private JPanel panel1;
    private JButton scheduleButton;
    private JButton addGradeButton;
    private JTextField idStudentTF;
    private JTextField nameStudentTF;
    private JTextField lectureTF;
    private JTextField gradeStudentTF;
    private JTable table1;
    private JButton updateGradeButton;
    private JButton profileSetingsButton;

    public TeacherView ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Teacher View");
    }

    public JTextField getIdStudentTF() {
        return idStudentTF;
    }

    public JTextField getNameStudentTF() {
        return nameStudentTF;
    }

    public JTextField getLectureTF() {
        return lectureTF;
    }

    public JTextField getGradeStudentTF() {
        return gradeStudentTF;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setScheduleButton(ActionListener a) {
        this.scheduleButton.addActionListener(a);
    }

    public void setAddGradeButton(ActionListener a) {
        this.addGradeButton.addActionListener(a);
    }

    public void setUpdateGradeButton(ActionListener a) {
        this.updateGradeButton.addActionListener(a);
    }

    public void setProfileSetingsButton(ActionListener a) {
        this.profileSetingsButton.addActionListener(a);
    }

    public void setTable1(MouseListener m) {
        this.table1.addMouseListener(m);
    }
}
