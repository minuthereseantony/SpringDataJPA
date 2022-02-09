package com.mta.springdatajpa.controller;

import com.mta.springdatajpa.exception.ResourceNotFoundException;
import com.mta.springdatajpa.model.Employee;
import com.mta.springdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException {
    Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Emplyoyee Not found"));
    return ResponseEntity.ok().body(employee);
    }

    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepository.save(employee);
    }
    @PatchMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long employeeId ,@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
    Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Resource not found"));
    employee.setEmail(employeeDetails.getEmail());
    employee.setFirstName(employeeDetails.getFirstName());
    employee.setLastName(employeeDetails.getLastName());
    return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

@DeleteMapping("employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value ="id") Long employeeId  ) throws ResourceNotFoundException {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee Not Found"));
        this.employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<String,Boolean >();
        response.put("Employee Deleted",true);
        return response;
    }

}
