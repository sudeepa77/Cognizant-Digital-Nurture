package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST =
                context.getBean("employeeList", ArrayList.class);

        LOGGER.debug("Employee List : {}", EMPLOYEE_LIST);

        LOGGER.info("END");
    }

    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");

        LOGGER.debug("Employee List : {}", EMPLOYEE_LIST);

        LOGGER.info("END");

        return EMPLOYEE_LIST;
    }
}