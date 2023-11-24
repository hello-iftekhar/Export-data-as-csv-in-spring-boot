package com.helloiftekhar.springcsvexport.service;

import com.helloiftekhar.springcsvexport.helper.CSVHelper;
import com.helloiftekhar.springcsvexport.model.Employee;
import com.helloiftekhar.springcsvexport.repository.EmployeeRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    public InputStreamResource load() throws IOException {

        List<Employee> employeeList = findAll();


        return new InputStreamResource(
                CSVHelper.writeCsv(employeeList)
        );
    }
}
