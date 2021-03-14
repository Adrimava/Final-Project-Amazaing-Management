package com.ironhack.companyservice.client;

import com.ironhack.companyservice.controller.dto.BusinessModelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient("amazaing-management-business-model-service")
public interface BusinessModelClient {

	@GetMapping("/business-model/{id}")
	@ResponseStatus(HttpStatus.OK)
	public BusinessModelDTO getBusinessModelById(@PathVariable Long id);

}
