package com.vehiclesservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.vehiclesservice.entity.VehicleDetails;
import com.vehiclesservice.entity.VehicleDetailsDto;
import com.vehiclesservice.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public String saveVehicleDetails(VehicleDetailsDto vehicleDetailsDto) {
		VehicleDetails vehicleDetails = new VehicleDetails();
		BeanUtils.copyProperties(vehicleDetailsDto, vehicleDetails);
		vehicleRepository.save(vehicleDetails);
		return "Vehicle Details saved succesfully";
	}

	@Override
	public String updateVehicleDetails(VehicleDetailsDto vehicleDetailsDto) {
		VehicleDetails vehicleDetails = vehicleRepository.findByBrandAndModel(vehicleDetailsDto.getBrand(),
				vehicleDetailsDto.getModel());
		if (vehicleDetails != null && !ObjectUtils.isEmpty(vehicleDetails)) {
			vehicleDetails.setBrand(vehicleDetailsDto.getBrand());
			vehicleDetails.setModel(vehicleDetailsDto.getModel());
			vehicleDetails.setPrice(vehicleDetailsDto.getPrice());
			vehicleDetails.setType(vehicleDetailsDto.getType());
			vehicleDetails.setYear(vehicleDetailsDto.getYear());
			vehicleRepository.save(vehicleDetails);
			return "Vehicle Details updated succesfully";
		} else {
			return "Vehicle Details not found ";

		}
	}

	@Override
	public List<VehicleDetails> getVehicleDetails() {
		return vehicleRepository.findAll();
	}

	@Override
	public VehicleDetails getVehicleDetail(String brand, String model) {
		VehicleDetails details = vehicleRepository.findByBrandAndModel(brand, model);
		if (!ObjectUtils.isEmpty(details) && details != null) {
			return details;
		} else {
			return details;
		}
	}

}
