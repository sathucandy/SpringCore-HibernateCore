package com.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarthak.hibernate.demo.entity.Course;
import com.sarthak.hibernate.demo.entity.Instructor;
import com.sarthak.hibernate.demo.entity.InstructorDetail;
import com.sarthak.hibernate.demo.entity.Review;
import com.sarthak.hibernate.demo.entity.Student;

public class AddCoursesforSpiderManDemo {

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

			// get the student spiderman from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded Student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			// create more courses
			Course tempCourse1 = new Course("Rubik - Time");
			Course tempCourse2 = new Course("Chess - Time");

			// add spiderman to courses
			tempCourse1.addStudents(tempStudent);
			tempCourse2.addStudents(tempStudent);

			// save the courses
			System.out.println("Saving the courses");
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
