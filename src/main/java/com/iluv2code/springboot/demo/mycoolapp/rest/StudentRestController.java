package com.iluv2code.springboot.demo.mycoolapp.rest;

import com.iluv2code.springboot.demo.mycoolapp.entity.StudentJackson;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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

        return theStudents.get(studentID);
    }
}
