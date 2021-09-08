package com.mastery.java.task.demo.service;

import com.mastery.java.task.demo.dao.EmployeeDao;
import com.mastery.java.task.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findTest(){

        return employeeDao.findAll();
    }

  /*  public String getById(String id){
       return employeeDao.getById(Long.parseLong(id));
    }*/

    public void deleteById(String id){
        employeeDao.deleteById(Long.parseLong(id));
    }
}
