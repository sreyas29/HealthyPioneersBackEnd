package com.Health.Pioneers.service;

import com.Health.Pioneers.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    public String savedCustomerDetails(Customer customer);

    public Optional<Customer> getCustomerByEmail(String emailId);
}
