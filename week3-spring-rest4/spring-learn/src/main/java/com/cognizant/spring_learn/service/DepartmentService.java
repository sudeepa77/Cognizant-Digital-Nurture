package com.cognizant.springlearn.service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.dao.DepartmentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional(readOnly = true)
    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        ArrayList<Department> departments =
                departmentDao.getAllDepartments();

        LOGGER.debug("Departments : {}", departments);

        LOGGER.info("END");

        return departments;
    }
}