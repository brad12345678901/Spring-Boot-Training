package com.iluv2code.springboot.demo.mycoolapp.dao;

import com.iluv2code.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
