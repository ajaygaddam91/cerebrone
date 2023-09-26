package com.cerebrone.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerebrone.crud.example.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
