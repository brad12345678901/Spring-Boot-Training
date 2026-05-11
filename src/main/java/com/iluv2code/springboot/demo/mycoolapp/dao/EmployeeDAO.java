package com.iluv2code.springboot.demo.mycoolapp.dao;

import com.iluv2code.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
