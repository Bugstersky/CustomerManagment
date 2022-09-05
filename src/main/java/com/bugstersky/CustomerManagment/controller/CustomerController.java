package com.bugstersky.CustomerManagment.controller;

import com.bugstersky.CustomerManagment.entites.Customer;
import com.bugstersky.CustomerManagment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Customer with id: " + id + " doesn't exist"));
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateEmployee(@PathVariable Long id, @RequestBody Customer employeeDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Customer with id: " + id + " doesn't exist"));

        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmailId(customer.getEmailId());

        Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id: " + id + " doesn't exist"));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
