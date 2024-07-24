package com.Health.Pioneers.controller;

import com.Health.Pioneers.entity.Customer;
import com.Health.Pioneers.service.CustomerService;
import com.Health.Pioneers.service.GeminiAIService;
import com.Health.Pioneers.service.PdfService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@RestController
@RequestMapping("/api/checkout")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private GeminiAIService aiService;

    @Autowired
    private CustomerService customerService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/analyzePdf")
    @ApiOperation(value = "Upload PDF File", notes = "Endpoint to upload a PDF file")
    public ResponseEntity<?> analyzePdf(@ApiParam(value = "PDF file to upload", required = true) @RequestPart("file") MultipartFile file) {
        // Check if the file is empty
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        // Check if the file is a PDF
        if (!file.getContentType().equals("application/pdf")) {
            return ResponseEntity.badRequest().body("Only PDF files are allowed");
        }
        Map<String, String>  listOfRequirement=pdfService.extractKeyValuePairs(file);
        Customer  customer= new Customer("Prasad", "Sahoo","prasadsahoo@gmail.com");
        customer.setListOfRecords(listOfRequirement);
        customerService.savedCustomerDetails(customer);

        return new ResponseEntity<>(listOfRequirement, HttpStatus.OK);
    }




    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        return customerService.getCustomerByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ai")
    public String getAIResponse(@RequestParam String input) {
        return aiService.getAIResponse(input);
    }

    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params) {
        return aiService.search(params);
    }

}

