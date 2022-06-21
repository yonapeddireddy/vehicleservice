
package com.customersservice.entity;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDto {

	private String firstName;

	private String lastName;

	private String email;

	private String city;

	private String state;

	private Long phoneNumber;

	/* private List<Vehicle> vehicles; */
}
