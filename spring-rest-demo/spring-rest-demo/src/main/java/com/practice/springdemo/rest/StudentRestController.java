package com.practice.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> students;

	// define @PostConstruct to load student data...only once
	@PostConstruct
	public void loadStudentData() {
		students = new ArrayList<>();

		students.add(new Student("Mark", "Cuban"));
		students.add(new Student("Lori", "Bream"));
		students.add(new Student("Kevin", "O'leary"));
	}

	// add endpoint for "/students" -return list of students
	@GetMapping("/students")
	private List<Student> getStudents() {
		return students;
	}

	// define endpoint for "/student/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check the studentId against the list size
		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return students.get(studentId);
	}
	/*
	 * 
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		// create a StudentResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	// add another exception handler...to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		// create a StudentResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	*/
}
