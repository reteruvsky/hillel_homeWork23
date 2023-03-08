
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        DAO dao = new DAO();
        Student first = new Student("Joe", "joesemail@gmail.com");
        Student second = new Student("Max", "maxesemail@gmai.com");
        Student third = new Student("John", "johnsemail@gmai.com");
        Student fourth = new Student("Mike", "mikesemail@gmail.com");
        Student fifth = new Student("Arni", "arnisemail@gmail.com");

        dao.addStudent(first);
        dao.addStudent(second);
        dao.addStudent(third);
        dao.addStudent(fourth);
        dao.addStudent(fifth);

        dao.removeStudent(18);

        dao.updateStudent(2);
        dao.updateStudent(4);

        dao.getAllStudents();

        dao.getStudentByID(16);
    }
}
