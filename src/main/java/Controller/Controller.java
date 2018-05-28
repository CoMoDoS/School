package Controller;

import Model.*;
import View.Login;
import View.Register;
import View.Schedule;
import View.StudentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;


public class Controller
{
    private Login login;
    private Register register;
//    private Schedule schedule;



    public Controller(Login login, Register register)
    {
        this.login = login;
        this.register = register;
//        this.schedule = schedule;
//        this.studentView = studentView;

        this.login.setVisible(true);

        this.login.setLogInButton(new LoginButton());
        this.login.setRegisterButton(new RegisterButton());

        this.register.setCreateAccountButton(new CreateAccountButton());


    }


    private class RegisterButton  implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            register.setVisible(true);
        }
    }

    private class LoginButton  implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String email = login.getTextField1().getText();
            String pass = String.valueOf(login.getPasswordField1().getPassword());

            Student student = new Student();
            Teacher teacher = new Teacher();
            Admin admin = new Admin();
            System.out.println(student.toString());

            try{
                student = StudentDAO.findByEmail(email);

            }catch (Exception exception)
            {
                JOptionPane.showMessageDialog(null,"Wrong Student ");
            }
            try{
                teacher = TeacherDAO.findByEmail(email);

            }catch (Exception exception)
            {
                JOptionPane.showMessageDialog(null,"Wrong Teacher");
            }
            try{
                admin = AdminDAO.findByEmail(email);

            }catch (Exception exception)
            {
                JOptionPane.showMessageDialog(null,"Wrong Admin ");
            }







            if(student.getName() != null && student.getPassword().compareTo(pass)==0) {
                StudentController studentController = new StudentController(1);
            }
            if(teacher.getName() != null && teacher.getPassword().compareTo(pass)==0) {
                TeacherController teacherController = new TeacherController(2);
            }
            if(admin.getName() != null && admin.getParola().compareTo(pass)==0) {
                AdminController adminController = new AdminController();
            }


        }
    }

    private class CreateAccountButton  implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }



}
