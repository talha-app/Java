package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICustomerRepository  extends CrudRepository<Customer,Integer> {
    @Query("FROM Customer c order by c.m_id asc ")
    List<Customer> findAllByOrderByIdAsc();

    @Query("FROM Customer c where c.m_firstName like lower(:name) or c.m_lastName like :name order by c.m_id asc ")
    List<Customer> findAllByFirstNameOrLastName(String name);

}
