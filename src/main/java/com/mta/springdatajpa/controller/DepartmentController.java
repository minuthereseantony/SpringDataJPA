package com.mta.springdatajpa.controller;

import com.mta.springdatajpa.exception.ResourceNotFoundException;
import com.mta.springdatajpa.model.Department;
import com.mta.springdatajpa.model.Employee;
import com.mta.springdatajpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    //getallDepartments
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("departments")
    public List<Department> getAllDepartments(){

        return this.departmentRepository.findAll();

    }
    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable(value="id") Long departmentId) throws ResourceNotFoundException {
        return this.departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found"));

    }

    @PostMapping("departments")

    public Department createDepartment(@RequestBody Department department){
        return this.departmentRepository.save(department);
    }
    @GetMapping("departments/{id}/employees")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable(value="id") Long departmentId) throws ResourceNotFoundException {

        Department dep = this.departmentRepository.findById(departmentId).orElseThrow(() ->new ResourceNotFoundException("Department not found"));
        return dep.getEmployees();


    }
}
