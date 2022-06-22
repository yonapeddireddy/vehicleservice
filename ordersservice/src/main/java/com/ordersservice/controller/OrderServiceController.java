package com.ordersservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordersservice.entity.OrderDetails;
import com.ordersservice.service.OrderService;

@RestController
@RequestMapping("/orderService")
public class OrderServiceController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/orderVehicle")
	public ResponseEntity<String> saveOrderDetails(@RequestParam String email, @RequestParam String brand,
			@RequestParam String model) {
		String response = orderService.saveCustomerDetails(email, brand, model);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/getUserVehicles")
	public List<OrderDetails> getUserVehicles(@RequestParam Integer userId) {
		return orderService.getUserVehicles(userId);
	}
}
