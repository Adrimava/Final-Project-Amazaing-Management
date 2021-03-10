package com.ironhack.amazaingmanagementedgeservice.repository;

import com.ironhack.amazaingmanagementedgeservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
