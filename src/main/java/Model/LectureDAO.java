package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class LectureDAO {

    public static EntityManager entityManager;
    public static EntityManagerFactory entityManagerFactory;


    public static void insert(Lecture lecture)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(lecture);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    public static Lecture findById(int id)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Lecture a1 = entityManager.find(Lecture.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static void delete(int id)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Lecture a1 = entityManager.find(Lecture.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(a1);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void update(int id, Lecture lecture)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Lecture a1 = entityManager.find(Lecture.class, id);
        entityManager.getTransaction().begin();
//        a1.setId(lecture.getId());
        a1.setName(lecture.getName());
        a1.setMark(lecture.getMark());
        a1.setStudent(lecture.getStudent());
        a1.setTeacher(lecture.getTeacher());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static Lecture findByName(String email)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Lecture.findByName");
        query.setParameter("name",email);
        Lecture a1 = (Lecture) query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static ArrayList<Lecture> selectAll(int idStudent)
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        String[] dateTabel = new String[40];
        ArrayList<Lecture> elem = new ArrayList<Lecture>();
        List<Lecture> lectures = entityManager.createNamedQuery("Lecture.showAll").getResultList();

        for ( Lecture c1 : lectures )
        {
            Lecture aux = new Lecture(c1.getName(), c1.getMark(), c1.getStudent(), c1.getTeacher());

            if (aux.getStudent().getId() == idStudent) {
                aux.setId(c1.getId());
                elem.add(aux);
            }
        }
        entityManager.close();
        entityManagerFactory.close();

        return elem;

    }

    public static ArrayList<Lecture> selectAll1(int idTeacher)
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        ArrayList<Lecture> elem = new ArrayList<Lecture>();
        List<Lecture> lectures = entityManager.createNamedQuery("Lecture.showAll").getResultList();

        for ( Lecture c1 : lectures )
        {
            Lecture aux = new Lecture(c1.getName(), c1.getMark(), c1.getStudent(), c1.getTeacher());
//            System.out.println(aux.toString());
//            System.out.println(aux.getStudent().getId());
            if (aux.getTeacher().getId() == idTeacher) {
                aux.setId(c1.getId());
                elem.add(aux);
            }
        }
        entityManager.close();
        entityManagerFactory.close();

        return elem;

    }

    public static ArrayList<Lecture> selectAll2()
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        ArrayList<Lecture> elem = new ArrayList<Lecture>();
        List<Lecture> lectures = entityManager.createNamedQuery("Lecture.showAll").getResultList();

        for ( Lecture c1 : lectures )
        {
            Lecture aux = new Lecture(c1.getName(), c1.getMark(), c1.getStudent(), c1.getTeacher());
//            System.out.println(aux.toString());
//            System.out.println(aux.getStudent().getId());

                aux.setId(c1.getId());
                elem.add(aux);

        }
        entityManager.close();
        entityManagerFactory.close();

        return elem;

    }



}
