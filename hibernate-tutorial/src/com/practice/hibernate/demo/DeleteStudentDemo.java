package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 3;

			//Get the new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on id: primary key
			System.out.println("\n Getting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Deleting student: " + myStudent);
			session.delete(myStudent);

			// commit the transaction
			session.getTransaction().commit();

			//Get the new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Delete student with id = 4
			System.out.println("Deleting student with id = 4");
			
			session.createQuery("delete from Student where id=4").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
