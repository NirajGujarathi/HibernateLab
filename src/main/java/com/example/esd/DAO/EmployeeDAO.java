package com.example.esd.DAO;

import com.example.esd.Bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee empObj);
    Employee getEmployeeByID (int empID);
    List<Employee> getEmployeeSalaryInRange(long lowerBound, long upperBound);
    boolean deleteEmployee(int empID);
    Double avgSalary();
}
