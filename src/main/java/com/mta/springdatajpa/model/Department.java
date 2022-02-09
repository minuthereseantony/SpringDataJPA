package com.mta.springdatajpa.model;

import javax.persistence.*;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(name="department_name")
    private String departmentNAme;
    @Column(name="department_head")
    private String departmentHead;

    public Department() {
    }

    public Department(Long departmentId, String departmentNAme, String departmentHead) {
        this.departmentId = departmentId;
        this.departmentNAme = departmentNAme;
        this.departmentHead = departmentHead;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentNAme() {
        return departmentNAme;
    }

    public void setDepartmentNAme(String departmentNAme) {
        this.departmentNAme = departmentNAme;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }
}
