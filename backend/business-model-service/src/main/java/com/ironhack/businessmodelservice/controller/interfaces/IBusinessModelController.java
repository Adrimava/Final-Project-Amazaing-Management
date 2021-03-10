package com.ironhack.businessmodelservice.controller.interfaces;

import com.ironhack.businessmodelservice.model.BusinessModel;

import java.util.List;

public interface IBusinessModelController {

	List<BusinessModel> getAllBusinessModel();
	BusinessModel getBusinessModelById(Long id);

}
