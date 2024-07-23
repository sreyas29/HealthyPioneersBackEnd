package com.Health.Pioneers.controller;

import com.Health.Pioneers.service.PdfService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/checkout")
public class PdfController {

    private PdfService pdfService;

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
        pdfService.extractKeyValuePairs(file);
        return new ResponseEntity<>("ReportAnalysis", HttpStatus.OK);
    }

}

