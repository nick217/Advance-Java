package com.practice.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query student table
			List<Student> students = session.createQuery("from Student").getResultList();
			// name of the table as in code, i.e. the name of the class, not the table name in Db, display the students
			displayStudents(students);

			// query students: lastName = 'Seinfeld'
			students = session.createQuery("from Student s where s.lastName='Seinfeld'").getResultList(); //table and column name as in code, not as in Db.
			
			// display the students
			displayStudents(students);
			
			// query students: lastName = 'Seinfeld' OR firstName = 'Elaine'
			students = session.createQuery("from Student s where "
					+ "s.lastName='Seinfeld' OR s.firstName='Elaine'").getResultList();
			
			// display the students
			displayStudents(students);
			
			// query students where email like '%comic.com'
			students = session.createQuery("from Student s where "
								+ "s.email LIKE '%comic.com'").getResultList();
						
			// display the students
			displayStudents(students);
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
