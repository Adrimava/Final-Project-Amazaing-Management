package com.ironhack.amazaingmanagementedgeservice.service.interfaces;

import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;

import java.util.List;

public interface IBusinessModelService {

	List<BusinessModel> getAllBusinessModel();
	BusinessModel getBusinessModelById(Long id);

}
