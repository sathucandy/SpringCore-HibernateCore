package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			System.out.println("Instructor: " + tempInstructor);
			System.out.println("Course: " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
