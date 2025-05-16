package com.data.session08.service;

import com.data.session08.model.Customer;
import com.data.session08.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepo.save(customer);
    }
}
