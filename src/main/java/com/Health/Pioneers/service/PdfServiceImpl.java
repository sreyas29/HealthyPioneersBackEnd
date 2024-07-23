package com.Health.Pioneers.service;

import com.Health.Pioneers.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PdfServiceImpl implements PdfService {

    private CustomerRepository customerRepository;

    @Autowired
    public PdfServiceImpl(CustomerRepository customerRepository, @Value("${stripe.key.secret}") String secretKey) {
        this.customerRepository = customerRepository;

        // init Stripe API with secretKey

    }



    @Override
    public void analyzePdf() {

    }

    @Override
    public void getInfoFromAi() {


    }
    public Map<String, String> extractKeyValuePairs(MultipartFile file) {
        Map<String, String> keyValuePairs = new HashMap<>();

//        try (PDDocument document = PDDocument.load(file.getInputStream())) {
//            PDFTextStripper stripper = new PDFTextStripper();
//            String text = stripper.getText(document);
//            keyValuePairs = parseTextToKeyValuePairs(text);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return keyValuePairs;
    }

    private Map<String, String> parseTextToKeyValuePairs(String text) {
        Map<String, String> keyValuePairs = new HashMap<>();

        // Example of a simple key-value pattern.
        // Adjust the regex pattern as needed to match your specific PDF format.
        String[] lines = text.split("\\n");
        for (String line : lines) {
            if (line.contains(":")) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    keyValuePairs.put(key, value);
                }
            }
        }

        return keyValuePairs;
    }


}
