package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.model.Employee;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
