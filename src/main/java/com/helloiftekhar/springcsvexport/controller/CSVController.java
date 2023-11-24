package com.helloiftekhar.springcsvexport.controller;

import com.helloiftekhar.springcsvexport.helper.CSVHelper;
import com.helloiftekhar.springcsvexport.model.Employee;
import com.helloiftekhar.springcsvexport.service.CSVService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class CSVController {

    @Autowired
    CSVService csvService;

    @GetMapping("/")
    public String home(ModelMap map) {
        map.put("employeeList", csvService.findAll());
        return "index";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadCSV() throws IOException {



        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=employee.csv")
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(csvService.load());
    }
}
