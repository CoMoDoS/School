package Controller;

import Model.Lecture;
import Model.LectureDAO;
import Model.Student;
import Model.StudentDAO;
import View.Group;
import View.Schedule;
import View.StudentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StudentController
{
    Schedule schedule = new Schedule();
    Group group = new Group();
    StudentView studentView = new StudentView();
    Student student;

    public StudentController(int id)
    {
        this.student = StudentDAO.findById(id);
        studentView.setVisible(true);
        showGradeStudent(studentView.getTable1(), id);

        this.studentView.setGroupButton(new GroupButton());
        this.studentView.setScheduleButton(new ScheduleButton());
//        this.studentView.setTable(new TableStudents());



    }

    private class GroupButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            group.setVisible(true);
            showGroupMates(group.getGroupTable(),student.getGroup() );
        }
    }

    private class ScheduleButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            schedule.setVisible(true);
        }
    }

//    private class TableStudents implements MouseListener {
//        public void mouseClicked(MouseEvent e) {
//
//        }
//
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        public void mouseExited(MouseEvent e) {
//
//        }
//    }
    public void showGroupMates(JTable table, int group)
    {
        ArrayList<Student> list = StudentDAO.selectAll(group);
        for ( int i=0; i<list.size(); i++)
            System.out.println(list.get(i).toString());
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Status");

        table.setModel(model);

        Object[] row = new Object[3];
        for ( Student s : list)
        {
            row[0] = s.getName();
            row[1] = s.getEmail();
            row[2] = s.getStatus();
            model.addRow(row);
        }
        model.fireTableDataChanged();
        table.setModel(model);
    }

    public void showGradeStudent(JTable table, int idStudent)
    {
        ArrayList<Lecture> list = LectureDAO.selectAll(idStudent);

//        for ( int i=0; i<list.size(); i++)
//            System.out.println(list.get(i).toString());

        DefaultTableModel model1 = new DefaultTableModel();

        model1.addColumn("Name");
        model1.addColumn("Teacher");
        model1.addColumn("Grade");

        table.setModel(model1);

        Object[] row = new Object[3];
        for ( int i=0; i<list.size(); i++)
        {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getTeacher().getName();
            row[2] = list.get(i).getMark();
            model1.addRow(row);
        }

        table.setModel(model1);
        model1.fireTableDataChanged();
    }
}

