package com.ironhack.businessmodelservice.service.interfaces;

import com.ironhack.businessmodelservice.model.BusinessModel;

import java.util.List;

public interface IBusinessModelService {

	List<BusinessModel> getAllBusinessModel();
	BusinessModel getBusinessModelById(Long id);

}
