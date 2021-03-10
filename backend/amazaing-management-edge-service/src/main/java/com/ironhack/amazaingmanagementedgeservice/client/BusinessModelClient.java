package com.ironhack.amazaingmanagementedgeservice.client;

import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient("amazaing-management-business-model-service")
public interface BusinessModelClient {

	@GetMapping("/business-model")
	@ResponseStatus(HttpStatus.OK)
	public List<BusinessModel> getAllBusinessModel();

	@GetMapping("/business-model/{id}")
	@ResponseStatus(HttpStatus.OK)
	public BusinessModel getBusinessModelById(@PathVariable Long id);

}
