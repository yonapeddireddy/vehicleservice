package com.ordersservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ordersservice.entity.OrderDetails;
import com.ordersservice.repository.OrderRepository;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerServiceClient orderServiceClient;

	@Autowired
	private VehicleServiceClient vehicleServiceClient;

	@Override
	public String saveCustomerDetails(String emial, String brand, String model) {
		try {
			OrderDetails customer = orderServiceClient.getCustomerDetails(emial);
			OrderDetails vehicles = vehicleServiceClient.getVehicleDetails(brand, model);
			if (customer.getEmail() != null && !ObjectUtils.isEmpty(customer.getEmail())
					&& vehicles.getVehicleId() != null && !ObjectUtils.isEmpty(vehicles.getVehicleId())) {
				OrderDetails orders = new OrderDetails();
				orders.setEmail(customer.getEmail());
				orders.setFirstName(customer.getFirstName());
				orders.setLastName(customer.getLastName());
				orders.setVehicleId(vehicles.getVehicleId());
				orders.setUserId(customer.getUserId());
				orderRepository.save(orders);
				return "Order placed successfully";
			}
		} catch (FeignException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return "Issue raised while placing the order.";

	}

	@Override
	public List<OrderDetails> getUserVehicles(Integer userId) {
		return orderRepository.findByUserId(userId);
	}

}
