package com.ordersservice.service;

import com.ordersservice.entity.OrderDetailsDto;

public interface OrderService {

	String saveCustomerDetails(String email, String brand, String model);

}
