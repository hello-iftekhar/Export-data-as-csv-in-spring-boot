package com.helloiftekhar.springcsvexport.repository;

import com.helloiftekhar.springcsvexport.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
