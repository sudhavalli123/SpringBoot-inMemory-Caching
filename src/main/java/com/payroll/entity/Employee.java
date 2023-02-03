package com.payroll.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Employee_Collection")

public class Employee {
    @Id
    private int empId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String deptId;
    private Date dob;
    private int salary;

}
