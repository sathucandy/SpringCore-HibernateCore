package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// Option2: Query with hiberrnate query

			// get the instructor from database
			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from instructor i " + "JOIN FETCH i.courses " + "where i.id =:theInstructorId",
					Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			// get the instructor
			query.setParameter("theInstructorId", theId);

			// execute the query
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("Luv 2 coode: Instructor: " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			// since courses are lazy loaded this should fail
			// get courses

			System.out.println("\nPrinting after the session is close\n");
			System.out.println("Luv 2 coode: Course: " + tempInstructor.getCourses());

			System.out.println("Luv 2 coode: Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
