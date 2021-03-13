package com.ironhack.employeeservice.repository;

import com.ironhack.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByPlayerId(Long playerId);
	List<Employee> findByCompanyId(Long companyId);

}
