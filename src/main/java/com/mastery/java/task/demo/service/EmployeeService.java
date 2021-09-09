package com.mastery.java.task.demo.service;

import com.mastery.java.task.demo.dao.EmployeeDao;
import com.mastery.java.task.demo.dao.NamedParameterJdbcEmployee;
import com.mastery.java.task.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private NamedParameterJdbcEmployee namedParameterJdbcEmployee;
    public List<Employee> findTest(){

        return employeeDao.findAll();
    }

    public Optional<Employee> getById(Long id){
       return   namedParameterJdbcEmployee.findById(id);
    }

    public void deleteById(String id){
        employeeDao.deleteById(Long.parseLong(id));
    }
    public void save( Long id,String lastName,String firstName, Long departmentId, String jobTitle      , String gender,Date dateOfBirth){
        Employee employee = new Employee(id,lastName,firstName,departmentId,jobTitle, gender, dateOfBirth);
        employeeDao.save(employee);
    }
    public void update(Long id,String lastName,String firstName, Long departmentId, String jobTitle      , String gender,Date dateOfBirth) {
        Employee employee = new Employee(id,lastName,firstName,departmentId,jobTitle, gender, dateOfBirth);
        namedParameterJdbcEmployee.update(employee);
    }
}
