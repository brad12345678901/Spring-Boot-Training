package com.iluv2code.springboot.demo.mycoolapp.service;

import com.iluv2code.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
