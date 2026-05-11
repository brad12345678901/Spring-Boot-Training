package com.iluv2code.springboot.demo.mycoolapp.rest;

import com.iluv2code.springboot.demo.mycoolapp.entity.StudentJackson;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<StudentJackson> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new StudentJackson("Poornima", "Patel"));
        theStudents.add(new StudentJackson("Mario", "Rossy"));
        theStudents.add(new StudentJackson("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<StudentJackson> getStudents() {
        return theStudents;
    }

    // define endpoint for "/students/{studentID}" - return student at index

    @GetMapping("/students/{studentID}")
    public StudentJackson getStudent(@PathVariable int studentID) {
        // jsut index in the list... keep it simple for now

        // check the StudentID again
        if ((studentID >= theStudents.size()) || (studentID < 0)) {
            throw new StudentNotFoundException("Student id not found - "+studentID);
        }

        return theStudents.get(studentID);
    }

    // Add an exception Handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        // return ErrorResponse
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
