package com.ironhack.companyservice.repository;

import com.ironhack.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	List<Company> findByPlayerId(Long playerId);
}
