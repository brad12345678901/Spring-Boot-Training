package com.iluv2code.springboot.demo.mycoolapp;

import com.iluv2code.springboot.demo.mycoolapp.dao.StudentDAO;
import com.iluv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

//			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating a student object... ");
		Student tempstudent = new Student("Daffy", "Duck", "daffy@iluv2code.com");
		//save the student
		System.out.println("Save student Object");
		studentDAO.save(tempstudent);
		//display id of the saved student
		int studentID = tempstudent.getId();
		System.out.println("Saved Student. Generated ID: "+studentID);
		//retrieve student based on the id: primary key
		System.out.println("Retrieve student with id: "+studentID);
		Student myStudent = studentDAO.findById(studentID);
		//display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a student object... ");
		Student tempstudent1 = new Student("John", "Doe", "john@iluv2code.com");
		Student tempstudent2 = new Student("Mary", "Public", "maryu@iluv2code.com");
		Student tempstudent3 = new Student("Benita", "Applebum", "benita@iluv2code.com");
		// save the student object
		System.out.println("Saving student... ");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a student object... ");
		Student tempstudent = new Student("Paul", "Doe", "paul@iluv2code.com");
		// save the student object
		System.out.println("Saving student... ");
		studentDAO.save(tempstudent);
		// display id of the student object
		System.out.println("Successfully inserted Student ID: "+tempstudent.getId());
	}

}
