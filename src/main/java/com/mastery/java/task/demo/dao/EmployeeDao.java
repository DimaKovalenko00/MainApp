package com.mastery.java.task.demo.dao;

import com.mastery.java.task.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "select employee_id,last_name,first_name from employee",
                (rs, rowNum) ->
                        new Employee(
                                rs.getLong("employee_id"),
                                rs.getString("last_name"),
                                rs.getString("first_name")
                        )
        );
    }

    public Optional<Employee> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from employee where employee_id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Employee(
                                rs.getLong("employee_id"),
                                rs.getString("last_name"),
                                rs.getString("last_name")
                        ))
        );
    }
    public void save(Employee employee) {
        jdbcTemplate.update(
                "insert into employee (employee_id,first_name, last_name) values(?,?,?)",
                employee.getEmployeeId(),employee.getFirstName(), employee.getLastName());
    }
    /*

    public int update(Employee employee) {
        return jdbcTemplate.update(
                "update employee set last_name = ?, first_name = ?, = ? where id = ?",
                employee.getLastName(),employee.getFirstName(), employee.getEmployeeId());
    }*/



    public void deleteById(Long id) {
         jdbcTemplate.update(
                "delete  from employee where employee_id = ?",
                id);
    }
}
