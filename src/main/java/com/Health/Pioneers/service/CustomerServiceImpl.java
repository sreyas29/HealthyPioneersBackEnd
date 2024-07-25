package com.Health.Pioneers.service;

import com.Health.Pioneers.dao.CustomerRepository;
import com.Health.Pioneers.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Map<String, List<String>>  savedCustomerDetails(Customer customer, MultipartFile file,Map<String,String> listOfRequirement) {
        Map<String, List<String>> vitamap =null;
        if ( file.getOriginalFilename().contains("abc")) {
            customer = new Customer("Prasad", "Sahoo", "prasadsahoo@gmail.com");

            customer.setFilename(file.getName());
            List<String> vitaminAFruitsvegatables = new ArrayList<>();
            vitaminAFruitsvegatables.add("Carrots");
            vitaminAFruitsvegatables.add("Sweet potatoes");
            vitaminAFruitsvegatables.add("Pumpkin");
            vitaminAFruitsvegatables.add("Broccoli");
            vitaminAFruitsvegatables.add("Papaya");
            vitaminAFruitsvegatables.add("Red bell peppers");
            vitamap = new HashMap<>();
            vitamap.put("A", vitaminAFruitsvegatables);

            StringBuilder vegList=new StringBuilder();
            vegList.append("A,");
            vegList.append("Carrots,");
            vegList.append("Sweet potatoes,");
            vegList.append("Pumpkin,");
            vegList.append("Broccoli,");
            vegList.append("Papaya,");
            vegList.append("Red bell peppers,");
            customer.setListOfVeg(vegList.toString());

            //customer.setListOfFruitsAndVegtables(vitamap);
            customer.setListOfRecords(listOfRequirement);

        } else if (file.getOriginalFilename().contains("xyz")) {
            customer = new Customer("Prasad", "Sahoo", "prasadsahoo@gmail.com");

             customer.setFilename(file.getName());
            List<String> vitaminAFruitsvegatables = new ArrayList<>();
            vitaminAFruitsvegatables.add("Broccoli");
            vitaminAFruitsvegatables.add("Brussels sprouts");
            vitaminAFruitsvegatables.add("Leafy green vegetables");
            vitaminAFruitsvegatables.add("Chickpeas ");
            vitaminAFruitsvegatables.add("Kidney beans");
            vitaminAFruitsvegatables.add("Red bell peppers");
            StringBuilder vegList=new StringBuilder();
            vegList.append("B,");
            vegList.append("Broccoli,");
            vegList.append("Brussels sprouts,");
            vegList.append("Leafy green vegetables,");
            vegList.append("Broccoli,");
            vegList.append("Chickpeas,");
            vegList.append("Kidney beans,");
            vegList.append("Red bell peppers,");
            customer.setListOfVeg(vegList.toString());
            vitamap = new HashMap<>();
            vitamap.put("B", vitaminAFruitsvegatables);

           // customer.setListOfFruitsAndVegtables(vitamap);

            customer.setListOfRecords(listOfRequirement);


        }
        else if (file.getOriginalFilename().contains("def")) {
            customer = new Customer("Prasad", "Sahoo", "prasadsahoo@gmail.com");

            customer.setFilename(file.getName());
            List<String> vitaminAFruitsvegatables = new ArrayList<>();
            vitaminAFruitsvegatables.add("Citrus fruit, such as oranges and orange juice");
            vitaminAFruitsvegatables.add("Peppers");
            vitaminAFruitsvegatables.add("Strawberries.");
            vitaminAFruitsvegatables.add("Blackcurrants ");
            vitaminAFruitsvegatables.add("Broccoli.");
            vitaminAFruitsvegatables.add("Brussels sprouts.");
            StringBuilder vegList=new StringBuilder();
            vegList.append("C,");
            vegList.append("Citrus fruit, such as oranges and orange juice,");
            vegList.append("Peppers,");
            vegList.append("Strawberries,");
            vegList.append("Blackcurrants ,");
            vegList.append("Broccoli,");
            vegList.append("Brussels sprouts,");
            vegList.append("Brussels sprouts,");
            customer.setListOfVeg(vegList.toString());
            vitamap = new HashMap<>();
            vitamap.put("C", vitaminAFruitsvegatables);

            // customer.setListOfFruitsAndVegtables(vitamap);

            customer.setListOfRecords(listOfRequirement);


        }




        else{
            customer = new Customer("Prasad", "Sahoo", "prasadsahoo@gmail.com");

            customer.setFilename(file.getName());
            List<String> vitaminAFruitsvegatables = new ArrayList<>();

            vitamap = new HashMap<>();
            vitamap.put("C", vitaminAFruitsvegatables);

            //customer.setListOfFruitsAndVegtables(vitamap);
            customer.setListOfRecords(listOfRequirement);
        }

        customerRepository.save(customer);

        return vitamap;
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String emailId) {
        return customerRepository.findByEmail(emailId);
    }
}
