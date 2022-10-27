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
        dept1.setDepartmentName("Engineering");
        dept1.setDeptAddress("Bangalore");
        deptdao.addDepartment(dept1);

        Department dept2= new Department();
        dept2.setDepartmentName("HR");
        dept2.setDeptAddress("Bangalore");
        deptdao.addDepartment(dept2);

        Department dept3= new Department();
        dept3.setDepartmentName("Sales");
        dept3.setDeptAddress("Mumbai");
        deptdao.addDepartment(dept3);


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
        Employee emp3= new Employee();
        emp3.setEmployeeName("emp3");
        emp3.setEmployeeGender("male");
        emp3.setSalary(90000);
        Employee emp4= new Employee();
        emp4.setEmployeeName("emp4");
        emp4.setEmployeeGender("male");
        emp4.setSalary(160000);
        Employee emp5= new Employee();
        emp5.setEmployeeName("emp5");
        emp5.setEmployeeGender("female");
        emp5.setSalary(115000);

        emp1.setDepartment(dept2);
        emp2.setDepartment(dept1);
        emp3.setDepartment(dept2);
        emp4.setDepartment(dept1);
        emp5.setDepartment(dept3);

        empdao.addEmployee(emp1);
        empdao.addEmployee(emp2);
        empdao.addEmployee(emp3);
        empdao.addEmployee(emp4);
        empdao.addEmployee(emp5);


        //retrieve employee by employeeID
        Employee empFromDB= empdao.getEmployeeByID(1);
        System.out.println(empFromDB);

        // get list of employee in salary range
        long lowerBound = 100000;
        long upperBound = 150000;
        List<Employee> listOfEmployee= empdao.getEmployeeSalaryInRange(lowerBound, upperBound);
        if(listOfEmployee.size()>0){
            for(Employee e: listOfEmployee){
                System.out.println(e);
            }
        }
        else{
            System.out.println("no employees in given salary range");
        }

        // delete employee
        int empID= 4;
        if(empdao.deleteEmployee(4))
            System.out.println("Delete Success");
        else
            System.out.println("Delete failed");

        // avg salary
        Double avgSalary= empdao.avgSalary();
        System.out.println("Average Salary of all Employees= "+avgSalary);


        // get employee list of department=2  emp1 and emp3 should be returned
        List<Employee> empListInDept=deptdao.employeeListInDepartment(2);
        if(empListInDept.size()>0){
            for(Employee e: empListInDept){
                System.out.println(e);
            }
        }
        else{
            System.out.println("no employees in department");
        }


        //add projects


        // get all projects


        // update project name

    }
}
