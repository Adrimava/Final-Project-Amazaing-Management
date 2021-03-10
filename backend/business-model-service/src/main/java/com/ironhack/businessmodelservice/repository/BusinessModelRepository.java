package com.ironhack.businessmodelservice.repository;

import com.ironhack.businessmodelservice.model.BusinessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessModelRepository extends JpaRepository<BusinessModel, Long> {
}
