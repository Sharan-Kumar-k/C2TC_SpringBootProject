package com.tnsif.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.service.CustomerService;

import jakarta.persistence.NoResultException;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService c;

    // Get all customers
    @GetMapping("/customerservice")
    public List<Customer> list() {
        return c.listAll();
    }

    // Add new customer
    @PostMapping("/customerservice")
    public void add(@RequestBody Customer c1) {
        c.save(c1);
    }

    // Get customer by ID
    @GetMapping("/customerservice/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        try {
            Customer c2 = c.get(id);
            return new ResponseEntity<>(c2, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete customer by ID
    @DeleteMapping("/customerservice/{id}")
    public void delete(@PathVariable Integer id) {
        c.delete(id);
    }

    // Update customer by ID
    @PutMapping("/customerservice/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer update_c) {
        try {
            Customer exist_c = c.get(id);
            exist_c.setC_name(update_c.getC_name());
            exist_c.setAddress(update_c.getAddress());
            c.update(exist_c);
            return new ResponseEntity<>(exist_c, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

