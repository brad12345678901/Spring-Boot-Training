package com.iluv2code.springboot.demo.mycoolapp.dao;

import com.iluv2code.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it, no need to code ;)
}
