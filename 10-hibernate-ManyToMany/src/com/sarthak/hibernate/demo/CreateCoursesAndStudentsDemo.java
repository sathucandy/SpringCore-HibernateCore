package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;
import com.sarthak.hibernate.demo.entity.Review;
import com.sarthak.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - Score one million points");

			System.out.println("\nSaving the course");
			session.save(tempCourse);
			System.out.println("Saved the course");

			// create the students

			Student tempStudent1 = new Student("sarthak", "gupta", "sarthakgupta98@gmail.com");
			Student tempStudent2 = new Student("Spider", "Man", "sarthakgupta98@gmail.com");

			// add students to course

			tempCourse.addStudents(tempStudent2);
			tempCourse.addStudents(tempStudent1);

			// save the students
			System.out.println("Saving students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
