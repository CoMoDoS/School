package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JButton registerButton;

    public Login() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Login");


    }

    public void setLogInButton(ActionListener a) {
        this.logInButton.addActionListener(a);
    }

    public void setRegisterButton(ActionListener a) {
        this.registerButton.addActionListener(a);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }
}
