package Model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student")

@NamedQueries(
        {
                @NamedQuery(name = "Student.findByEmail", query = "select S from Student S where S.email LIKE :email"),
                @NamedQuery(name = "Student.showAll", query = " FROM Student as stud"),
                @NamedQuery(name = "Student.findByName", query = "SELECT S FROM Student S WHERE S.name LIKE :name")
        })
public class Student
{
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "groupNr")
    private int groupNr;

    @Column(name = "status")
    private String status;



    public Student(){}

    public Student(String name, String email, String password, int group, String status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.groupNr = group;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroup() {
        return groupNr;
    }

    public void setGroup(int group) {
        this.groupNr = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gropu='" + groupNr + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
