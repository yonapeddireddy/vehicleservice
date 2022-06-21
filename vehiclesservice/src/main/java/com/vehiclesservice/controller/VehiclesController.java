package com.vehiclesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclesservice.entity.VehicleDetails;
import com.vehiclesservice.entity.VehicleDetailsDto;
import com.vehiclesservice.service.VehicleService;

@RestController
@RequestMapping("/vehicleService")
public class VehiclesController {
	@Autowired
	private VehicleService vehicleService;

	@PostMapping(path = "/saveVehicleDetails")
	public ResponseEntity<String> saveVehicleDetails(@RequestBody VehicleDetailsDto vehicleDetailsDto) {
		String response = vehicleService.saveVehicleDetails(vehicleDetailsDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/updateVehicleDetails")
	public ResponseEntity<String> updateVehicleDetails(@RequestBody VehicleDetailsDto vehicleDetailsDto) {
		String response = vehicleService.updateVehicleDetails(vehicleDetailsDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/allVehicles")
	public ResponseEntity<List> getVehicleDetails() {
		List<VehicleDetails> details = vehicleService.getVehicleDetails();
		return new ResponseEntity<List>(details, HttpStatus.OK);
	}

	@GetMapping("/vehicleDetails")
	public ResponseEntity<VehicleDetails> getVehicleDetails(@RequestParam String brand, @RequestParam String model) {
		VehicleDetails details = vehicleService.getVehicleDetail(brand, model);
		return new ResponseEntity<VehicleDetails>(details, HttpStatus.OK);
	}

}
