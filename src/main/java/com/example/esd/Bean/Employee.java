package com.example.esd.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="employee")     //  you can specify MySQL table name it is optional; by-default it takes class name as table name
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;

    @Column(name = "emp_name", nullable = false)
    private String employeeName;

    @Column(name= "emp_gender")
    private String employeeGender;

    @Column(name ="emp_salary")
    private long salary;

    @ManyToOne
    @JoinColumn(name="employee_dept_id")
    private Department department;

    public Employee(){

    }

    public Employee(int employeeID, String employeeName, String employeeGender, long salary, Department department) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.salary = salary;
        this.department = department;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // to string to print object as a string otherwise it returns object Hashcode
    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
