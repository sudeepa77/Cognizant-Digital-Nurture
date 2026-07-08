package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");

        ArrayList<Employee> employees =
                employeeService.getAllEmployees();

        LOGGER.debug("Employees : {}", employees);

        LOGGER.info("END");

        return employees;
    }
}