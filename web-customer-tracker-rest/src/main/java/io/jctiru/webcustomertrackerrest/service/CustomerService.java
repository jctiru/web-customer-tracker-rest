package io.jctiru.webcustomertrackerrest.service;

import java.util.List;

import io.jctiru.webcustomertrackerrest.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String searchName);

}
