package View;

import javax.swing.*;

public class Schedule extends JFrame {
    private JPanel panel1;
    private JLabel imageLabel;

    public Schedule ()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        this.setTitle("Register");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        imageLabel = new JLabel(new ImageIcon("F:\\Faculta\\An3Sem2\\PS\\School\\Screenshot_129.png"));
    }
}
