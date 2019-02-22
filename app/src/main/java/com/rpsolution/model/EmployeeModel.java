package com.rpsolution.model;

public class EmployeeModel {

    private String empId;

    public EmployeeModel(String empId) {
        this.empId = empId;
    }

    public EmployeeModel() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
