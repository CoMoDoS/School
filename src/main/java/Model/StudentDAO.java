package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {

    public static EntityManager entityManager;
    public static EntityManagerFactory entityManagerFactory;


    public static void insert(Student student)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    public static Student findById(int id)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Student a1 = entityManager.find(Student.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static void delete(int id)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Student a1 = entityManager.find(Student.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(a1);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void update(int id, Student student)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Student a1 = entityManager.find(Student.class, id);
        entityManager.getTransaction().begin();
//        a1.setId(student.getId());
        a1.setPassword(student.getPassword());
        a1.setName(student.getName());
        a1.setEmail(student.getEmail());
        a1.setStatus(student.getStatus());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static Student findByEmail(String email)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Student.findByEmail");
        query.setParameter("email",email);
        Student a1 = (Student) query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static Student findByName(String name)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Student.findByName");
        query.setParameter("name",name);
        Student a1 = (Student) query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static ArrayList<Student> selectAll(int group)
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        String[] dateTabel = new String[40];
        ArrayList<Student> elem = new ArrayList<Student>();
        List<Student> lectures = entityManager.createNamedQuery("Student.showAll").getResultList();

        for ( Student c1 : lectures )
        {
            Student aux = new Student(c1.getName(), c1.getEmail(), c1.getPassword(), c1.getGroup(), c1.getStatus());
            System.out.println(aux.toString());
            System.out.println(aux.getGroup());
            if (aux.getGroup() == group) {
                aux.setId(c1.getId());
                elem.add(aux);
            }
        }
        entityManager.close();
        entityManagerFactory.close();

        return elem;

    }

    public static ArrayList<Student> selectAll1()
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        ArrayList<Student> elem = new ArrayList<Student>();
        List<Student> lectures = entityManager.createNamedQuery("Student.showAll").getResultList();

        for ( Student c1 : lectures )
        {
            Student aux = new Student(c1.getName(), c1.getEmail(), c1.getPassword(), c1.getGroup(), c1.getStatus());
            System.out.println(aux.toString());
            System.out.println(aux.getGroup());

            aux.setId(c1.getId());
            elem.add(aux);

        }
        entityManager.close();
        entityManagerFactory.close();

        return elem;

    }


}
