package com.mta.springdatajpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(name="department_name")
    private String departmentName;
    @Column(name="department_head")
    private String departmentHead;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;

    public Department() {
    }

    public Department(Long departmentId, String departmentName, String departmentHead, List<Employee> employees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentNAme(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }
}
