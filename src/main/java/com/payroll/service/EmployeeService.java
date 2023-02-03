package com.payroll.service;


import com.payroll.dto.EmployeeDTO;
import com.payroll.entity.Employee;
import com.payroll.exception.ResourceNotFoundException;
import com.payroll.mapper.EmployeeMapper;
import com.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @CachePut(value = "employees", key="#employeeDTO.empId")
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        System.out.println("IN METHOD addEmployee");
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        Employee createdEmployee = employeeRepository.save(employee);
        EmployeeDTO createdEmployeeDTO = employeeMapper.toEmployeeDTO(createdEmployee);
        return createdEmployeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = employeeMapper.toEmployeeDTOList(employeeList);
        return employeeDTOList;
    }

    @Cacheable(value = "employees", key = "#empId")
    public EmployeeDTO getEmployeeById(int empId) {
        System.out.println("IN METHOD getEmployeeById");
        Optional<Employee> employee = employeeRepository.findById(empId);
        EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee.get());
        return employeeDTO;

    }

    @CachePut(value = "employees", key="#employeeDTO.empId")
    public EmployeeDTO updateEmployee( EmployeeDTO employeeDTO)
    {
        System.out.println("IN METHOD updateEmployee");
        int empId = employeeDTO.getEmpId();
        if(!employeeRepository.existsById(empId))
               throw  new ResourceNotFoundException("Employee", "Employee ID", empId);
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        Employee createdEmployee = employeeRepository.save(employee);
        EmployeeDTO createdEmployeeDTO = employeeMapper.toEmployeeDTO(createdEmployee);
        return createdEmployeeDTO;

    }

    @CacheEvict(value = "employees", key="#empId")
    public void deleteEmployee(int empId) {
        System.out.println("IN METHOD deleteEmployee....");
        if(!employeeRepository.existsById(empId))
            throw new ResourceNotFoundException("Employee", "Employee ID", empId);
        employeeRepository.deleteById(empId);
    }
}
