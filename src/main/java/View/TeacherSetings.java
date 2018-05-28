package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TeacherSetings extends JFrame {
    private JPanel panel1;
    private JTextField nameTF;
    private JTextField emailTF;
    private JPasswordField passTF;
    private JTextField statusTF;
    private JButton updateButton;


    public TeacherSetings ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Teacher Edit");
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getEmailTF() {
        return emailTF;
    }

    public JPasswordField getPassTF() {
        return passTF;
    }

    public JTextField getStatusTF() {
        return statusTF;
    }

    public void setUpdateButton(ActionListener a)
    {
        updateButton.addActionListener(a);
    }
}
