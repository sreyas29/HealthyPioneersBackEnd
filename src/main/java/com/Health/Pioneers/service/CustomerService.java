package com.Health.Pioneers.service;

import com.Health.Pioneers.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerService {

    public Map<String, List<String>>  savedCustomerDetails(Customer customer, MultipartFile file, Map<String, String> listOfRequirement);

    public Optional<Customer> getCustomerByEmail(String emailId);
}
