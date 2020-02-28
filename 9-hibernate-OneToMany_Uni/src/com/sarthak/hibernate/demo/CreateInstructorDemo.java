package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create the objects
			Instructor tempInstructor = new Instructor("Spider", "Man", "sarthakgupta98@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("Youtbe", "Hero");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// save the instructor
			System.out.println("Saving Instructor : " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
