package com.mastery.java.task.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;

    public Employee(long employee_id, String last_name, String first_name) {
        this.employeeId = employee_id;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    //private Gender gender;
}
