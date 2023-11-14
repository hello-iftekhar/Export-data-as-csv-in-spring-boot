package com.helloiftekhar.springcsvexport.helper;


import com.helloiftekhar.springcsvexport.model.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class CSVHelper {
    public static ByteArrayInputStream writeCsv(List<Employee> employeeList) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), CSVFormat.DEFAULT);

        // CSV Header
        csvPrinter.printRecord("Id", "Name", "Phone", "Email");

        // loop through the data and put the data to csvPrinter
        for(Employee employee: employeeList) {
            csvPrinter.printRecord(
                    String.valueOf(employee.getId()),
                    employee.getName(),
                    employee.getPhone(),
                    employee.getEmail()
            );
        }

        csvPrinter.flush();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
