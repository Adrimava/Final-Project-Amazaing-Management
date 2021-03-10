package com.ironhack.amazaingmanagementedgeservice.repository;

import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessModelRepository extends JpaRepository<BusinessModel, Long> {
}
