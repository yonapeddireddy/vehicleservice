package com.ordersservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordersservice.entity.OrderDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "vehicles-service")
@CircuitBreaker(name = "vehicles-service", fallbackMethod = "getVehicleDetailsFallBack")
public interface VehicleServiceClient {
	@GetMapping("vehicles/vehicleService/vehicleDetails")
	public OrderDetails getVehicleDetails(@RequestParam String brand, @RequestParam String model);

	default OrderDetails getVehicleDetailsFallBack(String brand, String model, Throwable ex) {

		ex.printStackTrace();
		return new OrderDetails();
	}
}
