package com.example.esd.DAO;

import com.example.esd.Bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee empObj);
    List<Employee> getEmployees();
    Employee getEmployeeByID (int empID);
}
