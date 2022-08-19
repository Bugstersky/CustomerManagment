package com.bugstersky.CustomerManagment.custpack.controller.repository;

import com.bugstersky.CustomerManagment.custpack.controller.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
}
