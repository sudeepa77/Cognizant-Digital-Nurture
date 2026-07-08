package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentDao.class);

    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        DEPARTMENT_LIST =
                context.getBean("departmentList", ArrayList.class);

        LOGGER.debug("Department List : {}", DEPARTMENT_LIST);

        LOGGER.info("END");
    }

    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        LOGGER.debug("Department List : {}", DEPARTMENT_LIST);

        LOGGER.info("END");

        return DEPARTMENT_LIST;
    }
}