
package com.customersservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.customersservice.entity.Customer;
import com.customersservice.entity.CustomerDto;
import com.customersservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String saveCustomerDetails(CustomerDto customerDto) {
		Customer customerDetails = customerRepository.findByEmail(customerDto.getEmail());
		if (ObjectUtils.isEmpty(customerDetails) && customerDetails == null) {
			Customer customer = new Customer();
			customer.setCity(customerDto.getCity());
			customer.setEmail(customerDto.getEmail());
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setPhoneNumber(customerDto.getPhoneNumber());
			customer.setState(customerDto.getState());
			customerRepository.save(customer);
			return "Customer Details saved successfully";
		} else
			return "Customer already exists";
	}

	@Override
	public String updateCustomerDetails(CustomerDto customerDto) {
		Customer customerDetails = customerRepository.findByEmail(customerDto.getEmail());
		if (ObjectUtils.isEmpty(customerDetails)) {
			return "Not a valid Customer";

		} else {

			customerDetails.setCity(customerDto.getCity());
			customerDetails.setEmail(customerDto.getEmail());
			customerDetails.setFirstName(customerDto.getFirstName());
			customerDetails.setLastName(customerDto.getLastName());
			customerDetails.setPhoneNumber(customerDto.getPhoneNumber());
			customerDetails.setState(customerDto.getState());
			customerRepository.save(customerDetails);
		}
		return "Customer Details updated Successfully";
	}

	@Override
	public String deleteCustomerDetails(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if (ObjectUtils.isEmpty(customer)) {
			return "unable to find the Customer";

		} else {
			customerRepository.delete(customer);
		}
		return "Customer Details deleted Successfully";
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();

	}

	@Override
	public Customer findCustomerDetails(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if (ObjectUtils.isEmpty(customer) && customer == null) {
			return null;
		} else {
			return customer;
		}
	}

}
