package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object

			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail

			System.out.println("tempInstructorDetail " + tempInstructorDetail);

			// print the associated instructor

			System.out.println("the associated instructor is: " + tempInstructorDetail.getInstructor());

			// now lets delete the instructor
			System.out.println("Hey i m deleting tempInstructor detsail " + tempInstructorDetail);

			// remove the associated object reference
			// break the bi-directional link

			tempInstructorDetail.getInstructor().setInstructorDetail(null);

			session.delete(tempInstructorDetail);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
		}

	}

}
