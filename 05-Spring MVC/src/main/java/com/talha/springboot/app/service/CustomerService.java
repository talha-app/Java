package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Customer;
import com.talha.springboot.app.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository m_repository;

    public CustomerService(ICustomerRepository repository) {
        m_repository = repository;
    }

    @Override
    public Customer findById(int id) {
        return m_repository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        var iterable = m_repository.findAll();
        return StreamSupport.stream(iterable.spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllByOrderByIdAsc() {
        return m_repository.findAllByOrderByIdAsc();
    }

    @Override
    public void deleteById(int id) {
        m_repository.deleteById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return m_repository.save(customer);
    }

    @Override
    public List<Customer> findAllByFirstNameOrLastName(String name) {
        return m_repository.findAllByFirstNameOrLastName(name);
    }
}
