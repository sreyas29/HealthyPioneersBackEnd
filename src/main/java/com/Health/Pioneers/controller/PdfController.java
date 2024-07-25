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

import java.util.*;


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
        Map<String, List<String>> vitamap =null;
        Map<String, String>  listOfRequirement=null;

        Map<String, List<String>> listOfVegetableWith=new HashMap<>();
        // Nothing is uploaded
        if(file == null){
            return ResponseEntity.badRequest().body("Nothing is uploaded");
        }
        // Check if the file is empty
        else if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        // Check if the file is a PDF
        else if (!file.getContentType().equals("application/pdf")) {
            return ResponseEntity.badRequest().body("Only PDF files are allowed");
        }
        else{
            listOfRequirement=pdfService.extractKeyValuePairs(file);
            if(file != null && !file.isEmpty()) {
                Customer customer= new Customer();
                listOfVegetableWith=customerService.savedCustomerDetails(customer, file, listOfRequirement);


            }
        }


        return new ResponseEntity<>(listOfVegetableWith, HttpStatus.OK);
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

