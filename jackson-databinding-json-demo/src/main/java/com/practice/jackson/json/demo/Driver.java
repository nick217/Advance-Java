package com.practice.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map/convert to POJO: data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print firstname and lastname
			System.out.println("First Name = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
