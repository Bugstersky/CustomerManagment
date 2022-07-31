package com.bugstersky.CustomerManagment.controller;

import com.bugstersky.CustomerManagment.model.Customer;
import com.bugstersky.CustomerManagment.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CusomterController {

    private final CustomerRepository customerRepository;

    public CusomterController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first,@RequestParam String last){
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "New customer had been added to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Customer findCustomerById(@RequestParam Integer id){
        return customerRepository.findCustomerById(id);
    }

}
