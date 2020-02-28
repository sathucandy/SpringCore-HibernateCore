package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;
import com.sarthak.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - Score one million points");

			// add some reviews
			tempCourse.addReview(new Review("Greate course loved it"));
			tempCourse.addReview(new Review("Cool Course"));
			tempCourse.addReview(new Review("Job well done"));

			// save the course it will also save all the reviews in one moment
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
