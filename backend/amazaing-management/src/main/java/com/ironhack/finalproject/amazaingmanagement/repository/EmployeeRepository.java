package com.ironhack.finalproject.amazaingmanagement.repository;

import com.ironhack.finalproject.amazaingmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
