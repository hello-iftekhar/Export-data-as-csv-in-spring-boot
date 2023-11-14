package com.helloiftekhar.springcsvexport.controller;

import com.helloiftekhar.springcsvexport.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

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
    public ResponseEntity<Resource> getFile() throws IOException {
        String filename = "employee.csv";
        InputStreamResource file = new InputStreamResource(csvService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}