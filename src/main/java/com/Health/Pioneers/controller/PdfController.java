package com.Health.Pioneers.controller;

import com.Health.Pioneers.service.PdfService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/checkout")
public class PdfController {

    private PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/analyzePdf")
    public ResponseEntity<?> placeOrder() {
        pdfService.analyzePdf();
        return new ResponseEntity<>("reportAnalysis", HttpStatus.OK);
    }

}

