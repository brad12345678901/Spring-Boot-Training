package com.iluv2code.springboot.demo.mycoolapp.dao;

import com.iluv2code.springboot.demo.mycoolapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        // execute the query and result list
        List<Employee> employees = theQuery.getResultList();
        // return the list of employees
        return employees;
    }
}
