package com.iluv2code.springboot.demo.mycoolapp.rest;

import com.iluv2code.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.iluv2code.springboot.demo.mycoolapp.entity.Employee;
import com.iluv2code.springboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // quick and dirty: inject employee DAO
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and returns a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
