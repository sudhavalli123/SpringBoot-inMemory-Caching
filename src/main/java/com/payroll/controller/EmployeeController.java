package com.payroll.controller;

import com.payroll.dto.EmployeeDTO;
import com.payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path="",produces = "application/json", consumes="application/json")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO createdEmpDTO = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmpDTO);

    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> retrieveEmployeeById(@PathVariable int empId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(empId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
    }

    @PutMapping(path = "", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployeeDTO);
    }

    @DeleteMapping(path="/{empId}")
    public ResponseEntity deleteEmployee(@PathVariable int empId){
        employeeService.deleteEmployee(Integer.valueOf(empId));
        String msg = "Employee with ID "+empId +" deleted Successfully!";
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
