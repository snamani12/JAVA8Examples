package com.nisum.examples.streamexamples;

import java.util.List;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String role;
    private String isBillable;
    private Department dept;
    private List<String> skillSet;

    public Employee(int employeeId, String firstName, String lastName, double salary, String role, String isBillable,
                    Department dept, List<String> skillSet) {
        super();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.role = role;
        this.isBillable = isBillable;
        this.dept = dept;
        this.skillSet = skillSet;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getIsBillable() {
        return isBillable;
    }
    public void setIsBillable(String isBillable) {
        this.isBillable = isBillable;
    }
    public Department getDept() {
        return dept;
    }
    public void setDept(Department dept) {
        this.dept = dept;
    }
    public List<String> getSkillSet() {
        return skillSet;
    }
    public void setSkillSet(List<String> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                ", isBillable='" + isBillable + '\'' +
                ", dept=" + dept +
                ", skillSet=" + skillSet +
                '}';
    }
}
