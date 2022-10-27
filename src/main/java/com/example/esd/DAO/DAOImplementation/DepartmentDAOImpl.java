package com.example.esd.DAO.DAOImplementation;

import com.example.esd.Bean.Department;
import com.example.esd.Bean.Employee;
import com.example.esd.DAO.DepartmentDAO;
import com.example.esd.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public boolean addDepartment(Department deptObj) {
        try(Session session = HibernateSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(deptObj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Department> getDepartmentList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Department> departmentList = new ArrayList<>();
            for (final Object d : session.createQuery("from Department ").list()) {
                departmentList.add((Department) d);
            }
            return departmentList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Employee> employeeListInDepartment(int deptID) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Department deptObj=session.get(Department.class, deptID);
            return deptObj.getEmployeesList();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
