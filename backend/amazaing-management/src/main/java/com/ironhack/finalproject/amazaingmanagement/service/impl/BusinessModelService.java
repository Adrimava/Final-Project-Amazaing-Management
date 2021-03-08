package com.ironhack.finalproject.amazaingmanagement.service.impl;

import com.ironhack.finalproject.amazaingmanagement.model.BusinessModel;
import com.ironhack.finalproject.amazaingmanagement.repository.BusinessModelRepository;
import com.ironhack.finalproject.amazaingmanagement.service.interfaces.IBusinessModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessModelService implements IBusinessModelService {

	@Autowired
	private BusinessModelRepository businessModelRepository;

	@Override
	public List<BusinessModel> getAllBusinessModel() {
		return businessModelRepository.findAll();
	}

}
