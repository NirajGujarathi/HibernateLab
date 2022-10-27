package com.example.esd.Driver;

import com.example.esd.Bean.Department;
import com.example.esd.Bean.Employee;
import com.example.esd.Bean.Project;
import com.example.esd.DAO.DAOImplementation.DepartmentDAOImpl;
import com.example.esd.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd.DAO.DAOImplementation.ProjectDAOImpl;
import com.example.esd.DAO.DepartmentDAO;
import com.example.esd.DAO.EmployeeDAO;
import com.example.esd.DAO.ProjectDAO;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Application Started");

        runHibernateLab();

        System.out.println("End");
    }

    private static void runHibernateLab() {


        System.out.println("-----------------------------------------------------------");
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
        System.out.println("--- \tDepartments Added Successfully! ---");
        System.out.println("-----------------------------------------------------------");


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
        emp2.setDepartment(dept3);
        emp3.setDepartment(dept2);
        emp4.setDepartment(dept1);
        emp5.setDepartment(dept1);

        empdao.addEmployee(emp1);
        empdao.addEmployee(emp2);
        empdao.addEmployee(emp3);
        empdao.addEmployee(emp4);
        empdao.addEmployee(emp5);
        System.out.println("--- \tEmployees Added Successfully! ---");
        System.out.println("-----------------------------------------------------------");


        //retrieve employee by employeeID
        Employee empFromDB= empdao.getEmployeeByID(1);

        System.out.println("--- \tRetrieved Employee using EmployeeID ---");
        System.out.println(empFromDB);
        System.out.println("-----------------------------------------------------------");


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
        System.out.println("--- \tRetrieved Employees in given salary range " +lowerBound+" - "+ upperBound+ "  ---");
        System.out.println("-----------------------------------------------------------");

        // delete employee
        int empID= 4;
        if(empdao.deleteEmployee(5))
            System.out.println("Employee Delete Success");
        else
            System.out.println("Delete failed");
        System.out.println("-----------------------------------------------------------");

        // avg salary
        Double avgSalary= empdao.avgSalary();
        System.out.println("Average Salary of all Employees= "+avgSalary);
        System.out.println("-----------------------------------------------------------");


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
        System.out.println("-----------------------------------------------------------");

        //add projects
//        Project p1=new Project("DataScience");
//        List<Employee> emplist1=new ArrayList<>();
//        emplist1.add(emp1);
//        emplist1.add(emp5);
//        p1.setEmployeesList(emplist1);
//
//        Project p2=new Project("Development");
//        List<Employee> emplist2=new ArrayList<>();
//        emplist2.add(emp3);
//        emplist2.add(emp1);
//        p2.setEmployeesList(emplist2);
//
//        Project p3=new Project("QA-Support");
//        List<Employee> emplist3=new ArrayList<>();
//        emplist3.add(emp2);
//        emplist3.add(emp3);
//        p3.setEmployeesList(emplist3);
//
//
//        ProjectDAO pDAO= new ProjectDAOImpl();
//        pDAO.addProject(p1);
//        pDAO.addProject(p2);
//        pDAO.addProject(p3);
//
//        System.out.println("Project added Successfully!");

        // get all projects


        // update project name

    }
}
