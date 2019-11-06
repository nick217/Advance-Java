package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Course;
import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;
import com.practice.hibernate.demo.entity.Review;
import com.practice.hibernate.demo.entity.Student;

public class AddCoursesForGwynethDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the student gwyneth from the database
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);

			System.out.println("\nLoaded Student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			// create more courses
			Course tempCourse1 = new Course("Stark Enterprises 101");
			Course tempCourse2 = new Course("Mastering the Art of being Ironwoman");

			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			System.out.println("\nCourses saved!");

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
