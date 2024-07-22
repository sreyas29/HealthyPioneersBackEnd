package com.Health.Pioneers.service;

import com.Health.Pioneers.dao.CustomerRepository;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PdfServiceImpl implements PdfService {

    private CustomerRepository customerRepository;

    @Autowired
    public PdfServiceImpl(CustomerRepository customerRepository, @Value("${stripe.key.secret}") String secretKey) {
        this.customerRepository = customerRepository;

        // init Stripe API with secretKey
        Stripe.apiKey = secretKey;
    }



    @Override
    public void analyzePdf() {

    }

    @Override
    public void getInfoFromAi() {

    }
}
