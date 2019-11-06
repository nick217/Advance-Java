package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Course;
import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;
import com.practice.hibernate.demo.entity.Review;
import com.practice.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Course theCourse = new Course("Pacman - How to score one million points");

			// save the course and leverage CascadeType.ALL
			session.save(theCourse);
			System.out.println("Saved the course: " + theCourse);
			// create the students
			Student student1 = new Student("Gwyneth", "Paltrow", "gwyneth@ironwoman.com");
			Student student2 = new Student("Adam", "Levine", "adam@maroon.com");

			// add students to the course
			theCourse.addStudent(student1);
			theCourse.addStudent(student2);

			// save the students
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + theCourse.getStudents());
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
