package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Course;
import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects

			Instructor instructor = new Instructor("Ross", "Geller", "ross@friends.com");

			InstructorDetail insDetail = new InstructorDetail("http://www.youtube.com/reginaPhalange", "Dinosaurs");
			// associate the objects
			instructor.setInstructorDetail(insDetail);

			// start a transaction
			session.beginTransaction();

			/*
			 * save the instructor
			 * 
			 * Note: This will ALSO save the details object because of
			 * CascadeType.ALL
			 */
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
