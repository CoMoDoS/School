package Controller;

import Model.*;
import View.Schedule;
import View.TeacherSetings;
import View.TeacherView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TeacherController {

    Schedule schedule = new Schedule();
    TeacherView teacherView = new TeacherView();
    TeacherSetings teacherSetings = new TeacherSetings();
    Teacher teacher;
    static int idLecture;


    public TeacherController(int id)
    {
        this.teacher = TeacherDAO.findById(id);
        teacherView.setVisible(true);

        showStudentsTeacher(teacherView.getTable1(), id);

        this.teacherView.setAddGradeButton(new AddGrade());
        this.teacherView.setScheduleButton(new ScheduleButton());
        this.teacherView.setTable1(new TableMouseListener());
        this.teacherView.setProfileSetingsButton(new ProfileSetings());
        this.teacherView.setUpdateGradeButton(new UpdateGrade());

        this.teacherSetings.setUpdateButton(new UpdateTeacher());



    }

    private class ScheduleButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            schedule.setVisible(true);
        }
    }
    private class UpdateGrade implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idStud = Integer.parseInt(teacherView.getIdStudentTF().getText());
            float grade = Float.parseFloat(teacherView.getGradeStudentTF().getText());
            String name = teacherView.getLectureTF().getText();
            Student student = StudentDAO.findById(idStud);
            Lecture lecture = new Lecture(name,grade,student,teacher);
            LectureDAO.update(LectureDAO.findById(idLecture).getId(),lecture);
            showStudentsTeacher(teacherView.getTable1(), teacher.getId());

        }
    }

    private class AddGrade implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idStud = Integer.parseInt(teacherView.getIdStudentTF().getText());
            float grade = Float.parseFloat(teacherView.getGradeStudentTF().getText());
            String name = teacherView.getLectureTF().getText();
            Student student = StudentDAO.findById(idStud);
            Lecture lecture = new Lecture(name,grade,student,teacher);
            LectureDAO.insert(lecture);
            showStudentsTeacher(teacherView.getTable1(), teacher.getId());




        }
    }

    private void showStudentsTeacher(JTable table1, int idTeacher)
    {
        ArrayList<Lecture> list = LectureDAO.selectAll1(idTeacher);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Student Name");
        model.addColumn("Lecture Name");
        model.addColumn("Grade");
        model.addColumn("Group");

        table1.setModel(model);

        Object[] row = new Object[5];
        for( Lecture l : list )
        {
            row[0] = l.getStudent().getId();
            row[1] = l.getStudent().getName();
            row[2] = l.getName();
            row[3] = l.getMark();
            row[4] = l.getStudent().getGroup();
            model.addRow(row);
        }
        model.fireTableDataChanged();
        table1.setModel(model);
    }

    private class TableMouseListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            int i = teacherView.getTable1().getSelectedRow();
            TableModel model = teacherView.getTable1().getModel();
            String name =  String.valueOf(model.getValueAt(i,2));

            teacherView.getIdStudentTF().setText(String.valueOf(model.getValueAt(i,0)));
            teacherView.getNameStudentTF().setText(String.valueOf(model.getValueAt(i,1)));
            teacherView.getLectureTF().setText(String.valueOf(model.getValueAt(i,2)));
            teacherView.getGradeStudentTF().setText(String.valueOf(model.getValueAt(i,3)));

            idLecture = LectureDAO.findByName(name).getId();
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

    private class ProfileSetings implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            teacherSetings.getNameTF().setText(teacher.getName());
            teacherSetings.getEmailTF().setText(teacher.getEmail());
            teacherSetings.getPassTF().setText(teacher.getPassword());
            teacherSetings.getStatusTF().setText(teacher.getStatus());

            teacherSetings.setVisible(true);
        }
    }


    private class UpdateTeacher implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = teacherSetings.getNameTF().getText();
            String email = teacherSetings.getEmailTF().getText();
            String pass = String.valueOf(teacherSetings.getPassTF().getPassword());
            System.out.println(pass);
            String status = teacherSetings.getStatusTF().getText();

            TeacherDAO.update(teacher.getId(),new Teacher(name,email,pass,status));
            teacher = TeacherDAO.findById(teacher.getId());
        }
    }
}
