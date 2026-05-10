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
			createStudent(studentDAO);
		};
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
