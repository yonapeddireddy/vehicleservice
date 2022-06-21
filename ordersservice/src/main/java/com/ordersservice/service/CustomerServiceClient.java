package com.ordersservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordersservice.entity.OrderDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "customer-service")
@CircuitBreaker(name = "customer-service", fallbackMethod = "getCustomerDetailsFallBack")
public interface CustomerServiceClient {
	@GetMapping("customer/customerservice/customerDetails")
	public OrderDetails getCustomerDetails(@RequestParam String email);

	default OrderDetails getCustomerDetailsFallBack(String email, Throwable ex) {
		ex.printStackTrace();
		return new OrderDetails();
	}

}
