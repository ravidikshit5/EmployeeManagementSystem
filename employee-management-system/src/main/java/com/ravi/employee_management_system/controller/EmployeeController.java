package com.ravi.employee_management_system.controller;

import com.ravi.employee_management_system.dto.EmployeeDto;
import com.ravi.employee_management_system.entity.Employee;
import com.ravi.employee_management_system.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;


    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getById(@PathVariable Long empId){
        Employee employee = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.getAllEmp();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long empId,@RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.updateEmployee(empId,employeeDto);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long empId){
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Employee information deleted successfully");
    }
}
