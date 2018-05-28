package Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "lecture")
@NamedQueries(
        {
            @NamedQuery(name = "Lecture.findByName", query = "SELECT L FROM Lecture L WHERE L.name LIKE :name"),
            @NamedQuery(name = "Lecture.showAll", query = " FROM Lecture as lec")
        })
public class Lecture {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private float mark;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentID", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherID", nullable = false)
    private Teacher teacher;

    public Lecture() {}


    public Lecture(String name, float mark, Student student, Teacher teacher) {
        this.name = name;
        this.mark = mark;
        this.student = student;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                ", student=" + student.getName() +
                ", teacher=" + teacher.getName() +
                '}';
    }
}
