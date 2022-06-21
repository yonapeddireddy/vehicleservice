
package com.customersservice.service;

import java.util.List;

import com.customersservice.entity.Customer;
import com.customersservice.entity.CustomerDto;

public interface CustomerService {

	String saveCustomerDetails(CustomerDto customerDto);

	String updateCustomerDetails(CustomerDto customerDto);

	String deleteCustomerDetails(String email);

	List<Customer> findAllCustomers();

	Customer findCustomerDetails(String email);

}
