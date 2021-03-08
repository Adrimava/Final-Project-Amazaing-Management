package com.ironhack.finalproject.amazaingmanagement.service.impl;

import com.ironhack.finalproject.amazaingmanagement.model.BusinessModel;
import com.ironhack.finalproject.amazaingmanagement.repository.BusinessModelRepository;
import com.ironhack.finalproject.amazaingmanagement.service.interfaces.IBusinessModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessModelService implements IBusinessModelService {

	@Autowired
	private BusinessModelRepository businessModelRepository;

	@Override
	public List<BusinessModel> getAllBusinessModel() {
		return businessModelRepository.findAll();
	}

	@Override
	public BusinessModel getBusinessModelById(Long id) {
		Optional<BusinessModel> businessModel = businessModelRepository.findById(id);

		if (businessModel.isPresent()) {
			return businessModel.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Business model not found");
		}
	}

}
