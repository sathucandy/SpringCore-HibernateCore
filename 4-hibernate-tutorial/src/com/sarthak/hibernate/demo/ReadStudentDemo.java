package com.sarthak.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use session object to save java object

			// start a transaction
			session.beginTransaction();

			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);

			System.out.println();

			// query the student with last name as parker
			theStudents = session.createQuery("from Student s where s.lastName = 'Parker'").getResultList();

			// display the students
			System.out.println("Students who have last name of parker");
			displayStudents(theStudents);

			System.out.println();

			// query the student with last name as parker or firstname as Ryan
			theStudents = session.createQuery("from Student s where s.lastName = 'Parker' OR s.firstName = 'Ryan'")
					.getResultList();

			// display the students
			System.out.println("Students who have last name of parker or first name as ryan");
			displayStudents(theStudents);

			System.out.println();

			/////////////// query students where email ends with gmail.com
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();

			// display the students
			System.out.println("Students who have last name of parker");
			displayStudents(theStudents);

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
