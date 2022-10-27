package com.example.esd.DAO.DAOImplementation;

import com.example.esd.Bean.Employee;
import com.example.esd.DAO.EmployeeDAO;
import com.example.esd.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean addEmployee(Employee empObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(empObj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Employee> getEmployees() {


        try (Session session = HibernateSessionUtil.getSession();){
            List<Employee> employeesList = new ArrayList<>();
            for (final Object employee : session.createQuery("from Employee ").list()) {
                employeesList.add((Employee) employee);
            }
            return employeesList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }

    }

    // create query in salary range
    // create namedQuery


    @Override
    public Employee getEmployeeByID(int empID) {

        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Employee.class, empID);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }


}
