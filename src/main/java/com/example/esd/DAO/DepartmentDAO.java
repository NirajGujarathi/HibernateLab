package com.example.esd.DAO;

import com.example.esd.Bean.Department;
import com.example.esd.Bean.Employee;

import java.util.List;

public interface DepartmentDAO {
    boolean addDepartment(Department deptObj);
    List<Employee> employeeListInDepartment(int deptID);
}
