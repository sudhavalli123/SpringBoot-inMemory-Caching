package com.payroll.mapper;

import com.payroll.dto.EmployeeDTO;
import com.payroll.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "Spring")
public interface EmployeeMapper {

    @Mapping(source="dob", target="dob", dateFormat = "MM-dd-yyyy")
    EmployeeDTO toEmployeeDTO(Employee employee);
    @Mapping(source="dob", target="dob", dateFormat="yyyy-MM-dd")
    Employee toEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employeeList);

}
