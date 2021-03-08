package com.ironhack.finalproject.amazaingmanagement.repository;

import com.ironhack.finalproject.amazaingmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
