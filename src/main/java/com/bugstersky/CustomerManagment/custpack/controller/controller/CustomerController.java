package com.bugstersky.CustomerManagment.custpack.controller.controller;

import com.bugstersky.CustomerManagment.custpack.controller.entity.Customer;
import com.bugstersky.CustomerManagment.custpack.controller.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Transactional
@RestController
public class CustomerController implements ErrorController {

    private final static String PATH = "/error";

    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        return "No Mapping Found";
    }

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "New customer had been added to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        if (id == null) {
            throw new NullPointerException("Record not found");
        }
         customerRepository.deleteById(id);
    }
}
