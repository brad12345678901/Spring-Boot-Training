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

    @GetMapping("/students/{studentID}")
    public StudentJackson getStudent(@PathVariable int studentID) {
        if ((studentID >= theStudents.size()) || (studentID < 0)) {
            throw new StudentNotFoundException("Student id not found - "+studentID);
        }

        return theStudents.get(studentID);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
