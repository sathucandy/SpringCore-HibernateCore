package com.sarthak.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// start a transaction and a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on id
			System.out.println("\nGetting with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating Student");
			myStudent.setFirstName("Scooby");

			// commit transaction
			session.getTransaction().commit();

			// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("\nUpdate email of all students");
			session.createQuery("update Student set email='foo@hotmail.com'").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
