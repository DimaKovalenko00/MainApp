package com.mastery.java.task.demo.dao;

import com.mastery.java.task.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
   /* public Employee getById(Long id) {
        return jdbcTemplate.queryForObject(
                "select employee_id,last_name,first_name from employee where employee_id = ?",
                new Employee{String.toString(id)},

        );
    }*/
   /* public int save(Employee employee) {
        return jdbcTemplate.update(
                "insert into employee (last_name, first_name) values(?,?)",
                Employee.getLastName(), Employee.getFirstName());
    }

    public int update(Employee employee) {
        return jdbcTemplate.update(
                "update books set price = ? where id = ?",
                employee.getPrice(), employee.getId());
    }*/



    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete employee where employee_id = ?",
                id);
    }
}
