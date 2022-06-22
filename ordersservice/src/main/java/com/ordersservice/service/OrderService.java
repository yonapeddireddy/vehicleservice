package com.ordersservice.service;

import java.util.List;

import com.ordersservice.entity.OrderDetails;
import com.ordersservice.entity.OrderDetailsDto;

public interface OrderService {

	String saveCustomerDetails(String email, String brand, String model);

	List<OrderDetails> getUserVehicles(Integer userId);

}
