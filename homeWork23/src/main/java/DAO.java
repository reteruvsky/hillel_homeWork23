import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    public void addStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.flush();
        session.clear();
        transaction.commit();
    }

    public void removeStudent(long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setEmail("deleted");
        session.update(student);
        transaction.commit();
    }

    public void getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        studentList = session.createQuery("From Student").list();
        transaction.commit();
        studentList.forEach(System.out::println);
    }

    public void getStudentByID(long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        transaction.commit();
        System.out.println(student);
    }
}
