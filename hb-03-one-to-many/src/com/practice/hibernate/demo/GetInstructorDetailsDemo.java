package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 11;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("Instructor Detail: " + instructorDetail);

			// also print the associated instructor
			System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
