package com.mastery.java.task.demo.dao;

import com.mastery.java.task.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class NamedParameterJdbcEmployee extends EmployeeDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update(
                "update employee set last_name = :lastName, first_name = :firstName, department_id = :departmentId, job_title = :jobTitle, gender = :gender, date_of_birth= :dateOfBirth where employee_id = :EmployeeId",
                new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "select * from employee where employee_id = :id",
                new MapSqlParameterSource("id", id),
                (rs, rowNum) ->
                        Optional.of(new Employee(
                                rs.getLong("employee_id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getLong("department_id"),
                                rs.getString("job_title"),
                                rs.getString("gender"),
                                rs.getDate("date_of_birth")
                        ))
        );
    }

}