package com.bugstersky.CustomerManagment.repository;

import com.bugstersky.CustomerManagment.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
