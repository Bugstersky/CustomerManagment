package com.bugstersky.CustomerManagment;

import com.bugstersky.CustomerManagment.entites.Customer;
import com.bugstersky.CustomerManagment.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.util.stream.Stream;


@SpringBootApplication
public class CustomerManagmentApplication  {


    public static void main(String[] args) {
        SpringApplication.run(CustomerManagmentApplication.class, args);
    }


}
