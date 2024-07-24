package com.Health.Pioneers.service;

import com.Health.Pioneers.dao.CustomerRepository;
import com.Health.Pioneers.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String savedCustomerDetails(Customer customer) {
        customerRepository.save(customer);

        return "Done";
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String emailId) {
        return customerRepository.findByEmail(emailId);
    }
}
