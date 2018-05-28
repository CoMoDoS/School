package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TeacherSettings extends JFrame {
    private JTable teacherTable;
    private JTextField idTeacherTf;
    private JTextField statusTeacherTF;
    private JTextField passTeacherTF;
    private JTextField nameTeacherTF;
    private JTextField emailTeacherTF;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel panel1;

    public TeacherSettings ()

    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Teacher Settings");
    }

    public JTable getTeacherTable() {
        return teacherTable;
    }

    public JTextField getIdTeacherTf() {
        return idTeacherTf;
    }

    public JTextField getStatusTeacherTF() {
        return statusTeacherTF;
    }

    public JTextField getPassTeacherTF() {
        return passTeacherTF;
    }

    public JTextField getNameTeacherTF() {
        return nameTeacherTF;
    }

    public JTextField getEmailTeacherTF() {
        return emailTeacherTF;
    }

    public void setTeacherTable(MouseListener m ) {
        this.teacherTable.addMouseListener(m);
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
