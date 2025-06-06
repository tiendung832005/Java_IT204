package com.data.session19.service;

import com.data.session19.entity.Customer;
import com.data.session19.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void addOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.delete(id);
    }

    public List<Customer> searchCustomers(String keyword) {
        return customerRepository.searchByNameOrEmail(keyword);
    }
}
