package com.data.session08.service;

import com.data.session08.model.Customer;

import java.util.List;

public interface CustomerService {
    List<com.data.session08.model.Customer> findAll();
    Customer findById(int id);

    boolean save(Customer customer);

}
