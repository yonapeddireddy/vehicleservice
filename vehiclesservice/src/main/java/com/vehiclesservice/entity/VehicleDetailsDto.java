package com.vehiclesservice.entity;

import lombok.Data;

@Data
public class VehicleDetailsDto {

	private String brand;
	private String model;
	private String year;
	private String type;
	private Long price;

}
