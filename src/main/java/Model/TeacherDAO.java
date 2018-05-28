package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class TeacherDAO {

    public static EntityManager entityManager;
    public static EntityManagerFactory entityManagerFactory;


    public static void insert(Teacher teacher)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    public static Teacher findById(int id)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Teacher a1 = entityManager.find(Teacher.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static void delete(int id)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Teacher a1 = entityManager.find(Teacher.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(a1);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void update(int id, Teacher teacher)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Teacher a1 = entityManager.find(Teacher.class, id);
        entityManager.getTransaction().begin();
//        a1.setId(teacher.getId());
        a1.setPassword(teacher.getPassword());
        a1.setName(teacher.getName());
        a1.setEmail(teacher.getEmail());
        a1.setStatus(teacher.getStatus());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static Teacher findByEmail(String email)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Teacher.findByEmail");
        query.setParameter("email",email);
        Teacher a1 = (Teacher) query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static Teacher findByName(String name)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Teacher.findByName");
        query.setParameter("name",name);
        Teacher a1 = (Teacher) query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return a1;
    }

    public static ArrayList<Teacher> selectAll()
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        ArrayList<Teacher> elem = new ArrayList<Teacher>();
        List<Teacher> teachers = entityManager.createNamedQuery("Teacher.showAll").getResultList();

        for ( Teacher c1 : teachers )
        {
            Teacher aux = new Teacher(c1.getName(), c1.getEmail(), c1.getPassword(),  c1.getStatus());
            System.out.println(aux.toString());

            aux.setId(c1.getId());
            elem.add(aux);

        }
        entityManager.close();
        entityManagerFactory.close();

        return elem;

    }




}
