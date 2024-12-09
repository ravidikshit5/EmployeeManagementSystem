package com.ravi.employee_management_system.service.impl;

import com.ravi.employee_management_system.dto.EmployeeDto;
import com.ravi.employee_management_system.entity.Employee;
import com.ravi.employee_management_system.exception.ResourceNotFoundException;
import com.ravi.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
       Employee employee = new Employee();
       employee.setFirstName(employeeDto.getFirstName());
       employee.setLastName(employeeDto.getLastName());
       employee.setEmail(employeeDto.getEmail());
       return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id "+empId));
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long empId,EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee is not exist with id "+empId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employeeRepository.save(employee);

    }

    @Override
  public String deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
        return null;
    }
}
