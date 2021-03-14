package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.BusinessModelClient;
import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IBusinessModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessModelService implements IBusinessModelService {

	@Autowired
	private BusinessModelClient businessModelClient;

	private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

	private List<BusinessModel> allBusinessModelFallBack() {
		return null;
	}

	private BusinessModel businessModelFallBack() {
		return null;
	}

	@Override
	public List<BusinessModel> getAllBusinessModel() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-business-model-service");

		List<BusinessModel> businessModelList = circuitBreaker.run(() -> businessModelClient.getAllBusinessModel(),
				throwable -> allBusinessModelFallBack());

		return businessModelList;
	}

	@Override
	public BusinessModel getBusinessModelById(Long id) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-business-model-service");

		BusinessModel businessModel = circuitBreaker.run(() -> businessModelClient.getBusinessModelById(id),
				throwable -> businessModelFallBack());

		return businessModelClient.getBusinessModelById(id);
	}

}
