package com.mastery.java.task.demo.rest;

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
    public String findAll( Model model) {
    return employeeService.findTest().toString();
    }

  /*  @GetMapping("{id}")
    public String getOne(@PathVariable String id) {
        return employeeService.getById(id).toString();
    }*/

    /*@PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);

        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }*/

    /*@PostMapping
    public List<Employee> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));

        messages.add(message);

        return message;
    }
*/
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {

        employeeService.deleteById(id);
    }
}
