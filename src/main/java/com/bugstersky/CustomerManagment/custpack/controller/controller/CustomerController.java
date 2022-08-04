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

    // To repair !!!
    @RequestMapping("/delete/{id}")
    public Customer deleteCustomerById(@PathVariable Integer id) throws Exception {
        if (id == null) {
            throw new Exception("Record not found");
        }
        return customerRepository.deleteCustomerById(id);
    }
}
