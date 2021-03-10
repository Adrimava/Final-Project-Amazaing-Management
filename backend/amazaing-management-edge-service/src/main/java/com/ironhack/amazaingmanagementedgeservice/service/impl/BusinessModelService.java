package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.BusinessModelClient;
import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IBusinessModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessModelService implements IBusinessModelService {

	@Autowired
	private BusinessModelClient businessModelClient;

	@Override
	public List<BusinessModel> getAllBusinessModel() {

		return businessModelClient.getAllBusinessModel();
	}

	@Override
	public BusinessModel getBusinessModelById(Long id) {

		return businessModelClient.getBusinessModelById(id);
	}

}
