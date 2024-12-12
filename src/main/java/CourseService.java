import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseService  {
    public void addCourse(String name, String code, int credit, String department) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Student.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Course course = new Course(name, code, credit, department);

        session.persist(course);
        tx.commit();
        session.close();
        sf.close();
    }

    public void getCourseByCode(String code) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Student.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Course c WHERE c.code = :code";
        List<Course> courseList = session.createQuery(hql, Course.class)
                .setParameter("code", code)
                .getResultList();

        for (Course course : courseList) {
            System.out.println(code);
        }

        tx.commit();
        session.close();
        sf.close();

    }
}
