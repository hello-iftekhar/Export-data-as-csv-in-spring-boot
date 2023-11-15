package com.helloiftekhar.springcsvexport.service;

import com.helloiftekhar.springcsvexport.helper.CSVHelper;
import com.helloiftekhar.springcsvexport.model.Employee;
import com.helloiftekhar.springcsvexport.repository.EmployeeRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVService {

    private final EmployeeRepository repository;

    public CSVService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public ByteArrayInputStream load() throws IOException {

        // get list of employee
        List<Employee> employeeList = findAll();

        return CSVHelper.writeCsv(employeeList);
    }
}
