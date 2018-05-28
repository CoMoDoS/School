package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Register extends JFrame{
    private JPanel panel1;
    private JTextField nameTF;
    private JTextField emailTF;
    private JPasswordField passTF1;
    private JPasswordField passTF2;
    private JButton createAccountButton;

    public Register ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Register");
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public JTextField getEmailTF() {
        return emailTF;
    }

    public JPasswordField getPassTF1() {
        return passTF1;
    }

    public JPasswordField getPassTF2() {
        return passTF2;
    }

    public void setCreateAccountButton(ActionListener a) {
        this.createAccountButton.addActionListener(a);
    }
}
