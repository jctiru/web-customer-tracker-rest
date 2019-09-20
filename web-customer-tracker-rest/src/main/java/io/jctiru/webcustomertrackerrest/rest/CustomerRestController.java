package io.jctiru.webcustomertrackerrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jctiru.webcustomertrackerrest.entity.Customer;
import io.jctiru.webcustomertrackerrest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		}

		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// .saveOrUpdate() checks the id if it is empty for creating new item else
		// update item based on id
		// Also to force a save of new item in case an id is passed
		customer.setId(0);
		customerService.saveCustomer(customer);

		return customer;
	}

}
