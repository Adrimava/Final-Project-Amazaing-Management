package com.ironhack.businessmodelservice.controller.impl;

import com.ironhack.businessmodelservice.controller.interfaces.IBusinessModelController;
import com.ironhack.businessmodelservice.model.BusinessModel;
import com.ironhack.businessmodelservice.service.interfaces.IBusinessModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BusinessModelController implements IBusinessModelController {

	@Autowired
	private IBusinessModelService businessModelService;

	@GetMapping("/business-model")
	@ResponseStatus(HttpStatus.OK)
	public List<BusinessModel> getAllBusinessModel() {
		return businessModelService.getAllBusinessModel();
	}

	@GetMapping("/business-model/{id}")
	@ResponseStatus(HttpStatus.OK)
	public BusinessModel getBusinessModelById(@PathVariable Long id) {
		return businessModelService.getBusinessModelById(id);
	}

}
