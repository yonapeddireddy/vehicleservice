package com.vehiclesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehiclesservice.entity.VehicleDetails;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleDetails, Integer> {

	VehicleDetails findByBrandAndModel(String brand, String model);

}
