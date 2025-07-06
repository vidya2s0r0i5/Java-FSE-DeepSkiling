package com.cognizant;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        // Get beans from Spring context
        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);

        // Test methods
        testGetAllCountries();
        testGetAllEmployees();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start: testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries = {}", countries);
        LOGGER.info("End: testGetAllCountries");
    }

    private static void testGetAllEmployees() {
        LOGGER.info("Start: testGetAllEmployees");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("Employees = {}", employees);
        LOGGER.info("End: testGetAllEmployees");
    }
}
