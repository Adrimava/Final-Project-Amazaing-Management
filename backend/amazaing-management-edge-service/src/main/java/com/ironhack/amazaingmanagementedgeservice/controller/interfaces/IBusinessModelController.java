package com.ironhack.amazaingmanagementedgeservice.controller.interfaces;

import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;

import java.util.List;

public interface IBusinessModelController {

	List<BusinessModel> getAllBusinessModel();
	BusinessModel getBusinessModelById(Long id);

}
