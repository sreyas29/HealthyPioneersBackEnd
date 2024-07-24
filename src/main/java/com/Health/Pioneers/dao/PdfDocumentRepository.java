package com.Health.Pioneers.dao;

import com.Health.Pioneers.entity.Customer;
import com.Health.Pioneers.entity.PdfDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfDocumentRepository extends JpaRepository<PdfDocument, Long> {


}
