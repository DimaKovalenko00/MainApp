package com.mastery.java.task.demo.dao;

import com.mastery.java.task.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class NamedParameterJdbcEmployee extends EmployeeDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  /*  @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update(
                "update employee set price = :price where id = :id",
                new BeanPropertySqlParameterSource(employee));
    }*/

    @Override
    public Optional<Employee> findById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "select employee_id,last_name,first_name from employee where employee_id = :id",
                new MapSqlParameterSource("id", id),
                (rs, rowNum) ->
                        Optional.of(new Employee(
                                rs.getLong("employee_id"),
                                rs.getString("last_name"),
                                rs.getString("first_name")
                        ))
        );
    }
/*

    @Override
    public List<Book> findByNameAndPrice(String name, BigDecimal price) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", "%" + name + "%");
        mapSqlParameterSource.addValue("price", price);

        return namedParameterJdbcTemplate.query(
                "select * from books where name like :name and price <= :price",
                mapSqlParameterSource,
                (rs, rowNum) ->
                        new Book(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getBigDecimal("price")
                        )
        );
    }
*/

}