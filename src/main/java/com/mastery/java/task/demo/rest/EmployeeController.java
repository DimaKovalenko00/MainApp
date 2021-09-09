package com.mastery.java.task.demo.rest;

import com.mastery.java.task.demo.dto.Employee;
import com.mastery.java.task.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public String findAll( ) {
    return employeeService.findAll().toString();
    }

   @GetMapping("{id}")
    public String getOne(@PathVariable String id) {
        return employeeService.getById(Long.valueOf(id)).toString();
    }

    @PutMapping("{id}")
    public void  update( @RequestBody Employee employeeWith) {
       employeeService.update(employeeWith.getEmployeeId(),employeeWith.getLastName(),employeeWith.getFirstName(),employeeWith.getDepartmentId(), employeeWith.getJobTitle(), employeeWith.getGender(),employeeWith.getDateOfBirth());
    }

    @PostMapping
    public void create( @RequestBody Employee employeeWith) {
         employeeService.save(employeeWith.getEmployeeId(),employeeWith.getLastName(),employeeWith.getFirstName(),employeeWith.getDepartmentId(), employeeWith.getJobTitle(), employeeWith.getGender(),employeeWith.getDateOfBirth());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {

        employeeService.deleteById(id);
    }
}
