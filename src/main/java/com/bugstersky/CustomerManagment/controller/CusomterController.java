package com.bugstersky.CustomerManagment.controller;

import com.bugstersky.CustomerManagment.model.Customer;
import com.bugstersky.CustomerManagment.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@RequestParam Integer id){
        customerRepository.deleteById(id);
        return "Customer had been deleted from repo!";
    }
}
