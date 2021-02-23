//package ru.koryaking;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.util.NoSuchElementException;
//
//
//public class CrudOperation {
//
//    private static SessionFactory factory;
//
//    public static void main(String[] args) {
//        try {
//            init();
//            createStudent("Mark", "Dark");
//            readStudent(4L);
//            updateStudent(4L, "Bruce","Batman");
//            deleteStudent(3L);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            shutdown();
//        }
//    }
//
//    public static void init() {
//        PrepareDataApp.forcePrepareData();
//        factory = new Configuration()
//                .configure("configs/hibernate.cfg.xml")
//                .buildSessionFactory();
//    }
//
//    public static void createStudent(String name, String mark) {
//        try (Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Student student = new Student(name, mark);
//            session.save(student);
//            session.getTransaction().commit();
//            System.out.println("CREATE: " + student);
//        }
//    }
//
//    public static void readStudent(Long id) {
//        try (Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Student student = session.get(Student.class, id);
//            System.out.println("READ: " + student);
//            session.getTransaction().commit();
//        }
//    }
//
//    public static void updateStudent(Long id, String name ,String newMark) {
//        try (Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Student student = session.get(Student.class, id);
//            student.setMark(newMark);
//            System.out.println("UPDATE: " + student);
//            session.getTransaction().commit();
//        }
//    }
//
//    public static void deleteStudent(Long id) {
//        try (Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Student student = session.get(Student.class, id);
//            if (student == null) {
//                throw new NoSuchElementException("Student with id = " + id + " is not found.");
//            }
//            session.delete(student);
//            session.getTransaction().commit();
//        }
//    }
//
//    public static void shutdown() {
//        factory.close();
//    }
//}
