package com.t1808a.entity;

public class Employee extends Person {

    private String employeeId;
    private String taxId;
    private String joinedAt;

    public Employee() {
    }

    public Employee(String employeeId, String taxId) {
        this.employeeId = employeeId;
        this.taxId = taxId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }
}
