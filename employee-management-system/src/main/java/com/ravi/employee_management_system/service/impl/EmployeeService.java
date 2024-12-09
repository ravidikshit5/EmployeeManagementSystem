package com.ravi.employee_management_system.service.impl;

import com.ravi.employee_management_system.dto.EmployeeDto;
import com.ravi.employee_management_system.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(Long empId);
    List<Employee> getAllEmp();
    Employee updateEmployee(Long empId,EmployeeDto employeeDto);
    String deleteEmployee(Long empId);

}
