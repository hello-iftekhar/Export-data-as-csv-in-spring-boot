package com.helloiftekhar.springcsvexport;

import com.github.javafaker.Faker;
import com.helloiftekhar.springcsvexport.model.Employee;
import com.helloiftekhar.springcsvexport.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCsvExportApplication {

//	@Autowired
//	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCsvExportApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		Faker faker = new Faker();
//
//		for(int i = 0; i < 50; i++) {
//			Employee employee = new Employee();
//			employee.setName(faker.name().fullName());
//			employee.setPhone(faker.phoneNumber().cellPhone());
//			employee.setEmail(faker.internet().emailAddress());
//			employeeRepository.save(employee);
//		}
//
//
//		return null;
//	}
}
