package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Customer;

import java.util.List;

public interface ICustomerService {

    Customer findById(int id);
    List<Customer> findAll();
    void deleteById(int id);
    Customer save(Customer customer);
    List<Customer> findAllByOrderByIdAsc();
    List<Customer> findAllByFirstNameOrLastName(String name);

}
