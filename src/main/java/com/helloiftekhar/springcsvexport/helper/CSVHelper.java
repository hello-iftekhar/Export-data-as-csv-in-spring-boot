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
        final CSVFormat format = CSVFormat.DEFAULT;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);
        csvPrinter.printRecord("Id", "Name", "Phone","Email");
        for (Employee employee : employeeList) {
            List<String> data = Arrays.asList(
                    String.valueOf(employee.getId()),
                    employee.getName(),
                    employee.getPhone(),
                    employee.getEmail()
            );

            csvPrinter.printRecord(data);
        }

        csvPrinter.flush();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
