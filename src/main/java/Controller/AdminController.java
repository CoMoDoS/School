package Controller;

import Model.*;
import View.AdminView;
import View.LectureSettings;
import View.StudentSettings;
import View.TeacherSettings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AdminController
{
    Admin admin;
    AdminView adminView ;
    StudentSettings studentSettings;
    TeacherSettings teacherSettings;
    LectureSettings lectureSettings;
    int idStudent;
    int idTeacher;
    int idLecture;
    String lectureName;
    public AdminController()
    {
        adminView = new AdminView();
        showTeachers(adminView.getTeacherTable());
        showStudents(adminView.getStudentTable());
        adminView.setVisible(true);
        adminView.getLectureNameTF().setText("Default");
        adminView.setAssignButton(new Assign());
        adminView.setStudentSetingsButton(new StudentSetting());
        adminView.setTeacherSetingsButton(new TeacherSetting());
        adminView.setLectureSetingsButton(new LectureSetting());
        adminView.setTeacherTable(new TeacherTable());
        adminView.setStudentTable(new StudentTable());

        studentSettings = new StudentSettings();
        studentSettings.setEndButton(new EndButton());
        studentSettings.setCreateButton(new CreateStudent());
        studentSettings.setUpdateButton(new UpdateStudent());
        studentSettings.setDeleteButton(new DeleteStudent());
        studentSettings.setStudentTable(new StudentTableStudent());
        studentSettings.setLectureTable(new LectureTableStudent());

        teacherSettings = new TeacherSettings();
        teacherSettings.setCreateButton(new CreateTeacher());
        teacherSettings.setUpdateButton(new UpdateTeacher());
        teacherSettings.setDeleteButton(new DeleteTeacher());
        teacherSettings.setTeacherTable(new TeacherTableTeacher());

        lectureSettings = new LectureSettings();
        lectureSettings.setCreateButton(new CreateLecture());
        lectureSettings.setUpdateButton(new UpdateLecture());
        lectureSettings.setDeleteButton(new DeleteLecture());
        lectureSettings.setTable1(new LectureTableLecture());
    }

    private class Assign implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Student student = StudentDAO.findById(idStudent);
            Teacher teacher = TeacherDAO.findById(idTeacher);
            String name = adminView.getLectureNameTF().getText();

            Lecture lecture = new Lecture(name,0,student,teacher);
            LectureDAO.insert(lecture);

        }
    }

    private class StudentSetting implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentSettings.setVisible(true);
            showStudents(studentSettings.getStudentTable());
            showLecures(studentSettings.getLectureTable());
        }
    }

    private class TeacherSetting implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            teacherSettings.setVisible(true);
            showTeachers(teacherSettings.getTeacherTable());
        }
    }

    private class LectureSetting implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            lectureSettings.setVisible(true);
            showAllLecures(lectureSettings.getTable1());

        }
    }

    private class TeacherTable implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = adminView.getTeacherTable().getSelectedRow();
            TableModel model = adminView.getTeacherTable().getModel();
            String name = String.valueOf(model.getValueAt(i,1));
            String email = String.valueOf(model.getValueAt(i,2));
            idTeacher = TeacherDAO.findByEmail(email).getId();

            adminView.getTeacherNameTF().setText(name);
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    private class StudentTable implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = adminView.getStudentTable().getSelectedRow();
            TableModel model = adminView.getStudentTable().getModel();
            String name = String.valueOf(model.getValueAt(i,1));
            String email = String.valueOf(model.getValueAt(i,2));
            idStudent = StudentDAO.findByEmail(email).getId();

            adminView.getStudentNameTF().setText(name);

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    public void showStudents(JTable table)
    {
        ArrayList<Student> list = StudentDAO.selectAll1();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Student ID");
        model.addColumn("Student Name");
        model.addColumn("Student Email");
        model.addColumn("Student Password");
        model.addColumn("Student Group");
        model.addColumn("Student Status");

        table.setModel(model);

        Object[] row = new Object[6];
        for(Student s : list )
        {
            row[0] = s.getId();
            row[1] = s.getName();
            row[2] = s.getEmail();
            row[3] = s.getPassword();
            row[4] = s.getGroup();
            row[5] = s.getStatus();
            model.addRow(row);
        }
        model.fireTableDataChanged();
        table.setModel(model);
    }

    public void showTeachers(JTable table)
    {
        ArrayList<Teacher> list = TeacherDAO.selectAll();

        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Teacher ID");
        model1.addColumn("Teacher Name");
        model1.addColumn("Teacher Email");
        model1.addColumn("Teacher Password");
        model1.addColumn("Teacher Status");

        table.setModel(model1);

        Object[] row = new Object[5];
        for(Teacher s : list )
        {
            row[0] = s.getId();
            row[1] = s.getName();
            row[2] = s.getEmail();
            row[3] = s.getPassword();
            row[4] = s.getStatus();
            model1.addRow(row);
        }
        model1.fireTableDataChanged();
        table.setModel(model1);
    }

    public void showLecures(JTable table)
    {
        ArrayList<Lecture> list = LectureDAO.selectAll(idStudent);
        DefaultTableModel model1 = new DefaultTableModel();

        model1.addColumn("ID");
        model1.addColumn("Name");
        model1.addColumn("Student");
        model1.addColumn("Teacher");
        model1.addColumn("Grade");

        table.setModel(model1);

        Object[] row = new Object[5];
        for ( Lecture l : list)
        {
            row[0] = l.getId();
            row[1] = l.getName();
            row[2] = l.getStudent().getName();
            row[3] = l.getTeacher().getName();
            row[4] = l.getMark();
            model1.addRow(row);
        }

        table.setModel(model1);
        model1.fireTableDataChanged();
    }

    public void showAllLecures(JTable table)
    {
        ArrayList<Lecture> list = LectureDAO.selectAll2();
        DefaultTableModel model1 = new DefaultTableModel();

        model1.addColumn("ID");
        model1.addColumn("Name");
        model1.addColumn("Student");
        model1.addColumn("Teacher");
        model1.addColumn("Grade");

        table.setModel(model1);

        Object[] row = new Object[5];
        for ( Lecture l : list)
        {
            row[0] = l.getId();
            row[1] = l.getName();
            row[2] = l.getStudent().getName();
            row[3] = l.getTeacher().getName();
            row[4] = l.getMark();
            model1.addRow(row);
        }

        table.setModel(model1);
        model1.fireTableDataChanged();
    }
    // TO DO
    private class EndButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String email = studentSettings.getEmailStudentTF().getText();
            String grade = studentSettings.getGradeStuentTF().getText();

            String message = "You have " + grade + " at the lecture " + lectureName;

            Start.sendEmail(email,message);
        }
    }

    private class CreateStudent implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String name = studentSettings.getNameStudentTF().getText();
            String email = studentSettings.getEmailStudentTF().getText();
            String pass1 = studentSettings.getPassStudentTF().getText();
            String pass = Start.sha256(pass1);
            int group = Integer.parseInt(studentSettings.getGroupStudentTF().getText());
            String status = studentSettings.getStatusStudentTF().getText();

            Student student = new Student(name,email,pass,group,status);
            StudentDAO.insert(student);
            showStudents(studentSettings.getStudentTable());

        }
    }

    private class UpdateStudent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(studentSettings.getIdStudentTF().getText());
            String name = studentSettings.getNameStudentTF().getText();
            String email = studentSettings.getEmailStudentTF().getText();
            String pass1 = studentSettings.getPassStudentTF().getText();
            String pass = null;
            if ( pass1.length()>100 )
                pass = pass1;
            else
                pass = Start.sha256(pass1);
            int group = Integer.parseInt(studentSettings.getGroupStudentTF().getText());
            String status = studentSettings.getStatusStudentTF().getText();

            StudentDAO.update(id, new Student(name,email,pass,group,status));
            showStudents(studentSettings.getStudentTable());

        }
    }

    private class DeleteStudent implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            StudentDAO.delete(idStudent);
            showStudents(studentSettings.getStudentTable());
        }
    }

    private class StudentTableStudent implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = studentSettings.getStudentTable().getSelectedRow();
            TableModel model = studentSettings.getStudentTable().getModel();
            String id = String.valueOf(model.getValueAt(i,0));
            idStudent = Integer.parseInt(id);
            String name = String.valueOf(model.getValueAt(i,1));
            String email = String.valueOf(model.getValueAt(i,2));
            String pass = String.valueOf(model.getValueAt(i,3));
            String group =String.valueOf( model.getValueAt(i,4));
            String status = String.valueOf(model.getValueAt(i,5));

            studentSettings.getIdStudentTF().setText(id);
            studentSettings.getNameStudentTF().setText(name);
            studentSettings.getEmailStudentTF().setText(email);
            studentSettings.getPassStudentTF().setText(pass);
            studentSettings.getGroupStudentTF().setText(group);
            studentSettings.getStatusStudentTF().setText(status);

            showLecures(studentSettings.getLectureTable());

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    private class LectureTableStudent implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = studentSettings.getLectureTable().getSelectedRow();
            TableModel model = studentSettings.getLectureTable().getModel();
            String grade = String.valueOf(model.getValueAt(i,4));
            lectureName = String.valueOf(model.getValueAt(i,1));
            studentSettings.getGradeStuentTF().setText(grade);
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    private class CreateTeacher implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String name = teacherSettings.getNameTeacherTF().getText();
            String email = teacherSettings.getEmailTeacherTF().getText();
            String pass1 = teacherSettings.getPassTeacherTF().getText();
            String pass = Start.sha256(pass1);
            String status = teacherSettings.getStatusTeacherTF().getText();

            TeacherDAO.insert(new Teacher(name,email,pass,status));
            showTeachers(teacherSettings.getTeacherTable());

        }
    }

    private class UpdateTeacher implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String name = teacherSettings.getNameTeacherTF().getText();
            String email = teacherSettings.getEmailTeacherTF().getText();
            String pass1 = teacherSettings.getPassTeacherTF().getText();
            String pass = null;
            if (pass1.length() > 100)
                pass = pass1;
            else
                pass = Start.sha256(pass1);
            String status = teacherSettings.getStatusTeacherTF().getText();

            TeacherDAO.update(idTeacher , new Teacher(name,email,pass,status));
            showTeachers(teacherSettings.getTeacherTable());
        }
    }

    private class DeleteTeacher implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TeacherDAO.delete(idTeacher);
            showTeachers(teacherSettings.getTeacherTable());

        }
    }

    private class TeacherTableTeacher implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = teacherSettings.getTeacherTable().getSelectedRow();
            TableModel model = teacherSettings.getTeacherTable().getModel();

            String id = String.valueOf(model.getValueAt(i,0));
            idTeacher = Integer.parseInt(id);
            String name = String.valueOf(model.getValueAt(i,1));
            String email = String.valueOf(model.getValueAt(i,2));
            String pass = String.valueOf(model.getValueAt(i,3));
            String staus = String.valueOf(model.getValueAt(i,4));

            teacherSettings.getIdTeacherTf().setText(id);
            teacherSettings.getNameTeacherTF().setText(name);
            teacherSettings.getEmailTeacherTF().setText(email);
            teacherSettings.getPassTeacherTF().setText(pass);
            teacherSettings.getStatusTeacherTF().setText(staus);
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }



    private class LectureTableLecture implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int i = lectureSettings.getTable1().getSelectedRow();
            TableModel model = lectureSettings.getTable1().getModel();

            String id = String.valueOf(model.getValueAt(i,0));
            idLecture = Integer.parseInt(id);
            String name = String.valueOf(model.getValueAt(i,1));
            String student = String.valueOf(model.getValueAt(i,2));
            String teacher = String.valueOf(model.getValueAt(i,3));
            String grade = String.valueOf(model.getValueAt(i,4));

            lectureSettings.getIdLectureTF().setText(id);
            lectureSettings.getNameLectureTF().setText(name);
            lectureSettings.getStudentTF().setText(student);
            lectureSettings.getTeacherTF().setText(teacher);
            lectureSettings.getGradeTF().setText(grade);

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    private class UpdateLecture implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = lectureSettings.getNameLectureTF().getText();
            String student = lectureSettings.getStudentTF().getText();
            String teacher = lectureSettings.getTeacherTF().getText();
            float grade = Float.parseFloat(lectureSettings.getGradeTF().getText());

            Student st = StudentDAO.findByName(student);
            Teacher te = TeacherDAO.findByName(teacher);

            LectureDAO.update(idLecture, new Lecture(name,grade,st,te));
            showAllLecures(lectureSettings.getTable1());
        }
    }

    private class DeleteLecture implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LectureDAO.delete(idLecture);
            showAllLecures(lectureSettings.getTable1());
        }
    }

    private class CreateLecture implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = lectureSettings.getNameLectureTF().getText();
            String student = lectureSettings.getStudentTF().getText();
            String teacher = lectureSettings.getTeacherTF().getText();
            float grade = Float.parseFloat(lectureSettings.getGradeTF().getText());

            Student st = StudentDAO.findByName(student);
            Teacher te = TeacherDAO.findByName(teacher);

            LectureDAO.insert(new Lecture(name,grade,st,te));
            showAllLecures(lectureSettings.getTable1());
        }
    }
}
