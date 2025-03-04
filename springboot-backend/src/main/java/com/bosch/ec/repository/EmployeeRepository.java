package com.bosch.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.ec.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
