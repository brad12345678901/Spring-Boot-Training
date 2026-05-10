package com.iluv2code.springboot.demo.mycoolapp;

import com.iluv2code.springboot.demo.mycoolapp.dao.StudentDAO;
import com.iluv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieved student based on primary key id
		int studentId = 1;
		System.out.println("Getting Student ID: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to Scooby
		System.out.println("Updating Student... ");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get the list of the students with the last name
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		//display the list of students

		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get the list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students

		for (Student tempstudent: theStudents) {
			System.out.println(tempstudent);
		}
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
