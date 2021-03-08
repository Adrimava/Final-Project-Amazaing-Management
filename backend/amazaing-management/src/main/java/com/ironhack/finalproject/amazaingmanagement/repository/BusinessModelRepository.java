package com.ironhack.finalproject.amazaingmanagement.repository;

import com.ironhack.finalproject.amazaingmanagement.model.BusinessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessModelRepository extends JpaRepository<BusinessModel, Long> {
}
