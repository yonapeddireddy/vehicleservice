package com.ordersservice.entity;

import lombok.Data;

@Data
public class OrderDetailsDto {
	private String firstName;
	private String lastName;
	private String email;
	private Integer vehicleId;
	private Integer userId;

}
