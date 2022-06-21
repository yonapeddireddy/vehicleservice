
package com.customersservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customersservice.entity.Customer;
import com.customersservice.entity.CustomerDto;
import com.customersservice.service.CustomerService;

@RestController
@RequestMapping("/customerservice")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/saveCustomerDetails")
	public ResponseEntity<String> saveCustomerDetails(@RequestBody CustomerDto customerDto) {
		String response = customerService.saveCustomerDetails(customerDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/updateCustomerDetails")
	public ResponseEntity<String> updateCustomerDetails(@RequestBody CustomerDto customerDto) {
		String response = customerService.updateCustomerDetails(customerDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomerDetails")
	public ResponseEntity<String> deleteCustomerDetails(@RequestParam String email) {
		String response = customerService.deleteCustomerDetails(email);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List> customerDetails() {
		List<Customer> customers = customerService.findAllCustomers();
		return new ResponseEntity<List>(customers, HttpStatus.OK);

	}

	@GetMapping("/customerDetails")
	public ResponseEntity<Customer> customerDetails(@RequestParam String email) {
		Customer customers = customerService.findCustomerDetails(email);
		return new ResponseEntity<Customer>(customers, HttpStatus.OK);

	}
}
