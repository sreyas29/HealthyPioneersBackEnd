package com.Health.Pioneers.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public interface PdfService {

    public void analyzePdf();

    public void getInfoFromAi();

    public Map<String, String> extractKeyValuePairs(MultipartFile file);


}
