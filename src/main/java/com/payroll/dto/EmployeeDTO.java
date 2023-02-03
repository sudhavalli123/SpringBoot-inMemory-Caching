package com.payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int empId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String deptId;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date dob;
    private int salary;
}
