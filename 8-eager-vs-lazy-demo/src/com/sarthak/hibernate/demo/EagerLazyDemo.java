package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from database
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// get the instructor
			System.out.println("Luv 2 coode: Instructor: " + tempInstructor);

			// get courses
			System.out.println("Luv 2 coode: Course: " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			// since courses are lazy loaded this should fail
			// get courses
			// To resolve this option1 - call a getter method while the session is open lile
			// line 35
			// Option2: Query with hql like in fetch join demo

			System.out.println("\nPrinting after the session is close\n");
			System.out.println("Luv 2 coode: Course: " + tempInstructor.getCourses());

			System.out.println("Luv 2 coode: Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
