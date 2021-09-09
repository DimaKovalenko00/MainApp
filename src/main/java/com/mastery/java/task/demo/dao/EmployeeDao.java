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
                "select * from employee",
                (rs, rowNum) ->
                        new Employee(
                                rs.getLong("employee_id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getLong("department_id"),
                                rs.getString("job_title"),
                                rs.getString("gender"),
                                rs.getDate("date_of_birth")
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
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getLong("department_id"),
                                rs.getString("job_title"),
                                rs.getString("gender"),
                                rs.getDate("date_of_birth")
                        ))
        );
    }
    public void save(Employee employee) {
        jdbcTemplate.update(
                "insert into employee (employee_id,first_name, last_name,department_id, job_title, gender, date_of_birth) values(?,?,?,?,?,?,?)",
                employee.getEmployeeId(),employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(),employee.getDateOfBirth());
    }


    public int update(Employee employee) {
        return jdbcTemplate.update(
                "update employee set first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?, date_of_birth= ?  where employee_id = ?",
                employee.getFirstName(), employee.getLastName(),employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(),employee.getDateOfBirth(), employee.getEmployeeId());
    }



    public void deleteById(Long id) {
         jdbcTemplate.update(
                "delete  from employee where employee_id = ?",
                id);
    }
}
