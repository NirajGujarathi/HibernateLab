package com.example.esd.Driver;

import com.example.esd.Bean.Department;
import com.example.esd.Bean.Employee;
import com.example.esd.DAO.DAOImplementation.DepartmentDAOImpl;
import com.example.esd.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd.DAO.DepartmentDAO;
import com.example.esd.DAO.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Application Started");

        runHibernateLab();

        System.out.println("End");
    }

    private static void runHibernateLab() {


        DepartmentDAO deptdao= new DepartmentDAOImpl();
        // add department
        Department dept1= new Department();
        dept1.setDepartmentName("Development");
        dept1.setDeptAddress("Mumbai");
        deptdao.addDepartment(dept1);

        Department dept2= new Department();
        dept2.setDepartmentName("DataScience");
        dept2.setDeptAddress("Bangalore");
        deptdao.addDepartment(dept2);


        EmployeeDAO empdao= new EmployeeDAOImpl();
        // add employees
        Employee emp1= new Employee();
        emp1.setEmployeeName("emp1");
        emp1.setEmployeeGender("male");
        emp1.setSalary(120000);
        Employee emp2= new Employee();
        emp2.setEmployeeName("emp2");
        emp2.setEmployeeGender("female");
        emp2.setSalary(130000);

        emp1.setDepartment(dept2);
        emp2.setDepartment(dept1);

        empdao.addEmployee(emp1);
        empdao.addEmployee(emp2);

        //retrieve employee by employeeID
        Employee empFromDB= empdao.getEmployeeByID(1);
        System.out.println(empFromDB);

        //get all employees
        List<Employee> listOfEmployee= empdao.getEmployees();
        if(listOfEmployee.size()>0){
            for(Employee e: listOfEmployee){
                System.out.println(e);
            }
        }
        else{
            System.out.println("no employees");
        }

    }
}
