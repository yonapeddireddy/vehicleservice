package com.vehiclesservice.service;

import java.util.List;

import com.vehiclesservice.entity.VehicleDetails;
import com.vehiclesservice.entity.VehicleDetailsDto;

public interface VehicleService {

	String saveVehicleDetails(VehicleDetailsDto vehicleDetailsDto);

	String updateVehicleDetails(VehicleDetailsDto vehicleDetailsDto);

	List<VehicleDetails> getVehicleDetails();

	VehicleDetails getVehicleDetail(String brand, String model);

}
