package com.example.esd.DAO.DAOImplementation;

import com.example.esd.Bean.Employee;
import com.example.esd.Bean.Project;
import com.example.esd.DAO.ProjectDAO;
import com.example.esd.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    @Override
    public boolean addProject(Project projectObj) {
        return false;
    }


    @Override
    public List<Project> getProjectList() {
        try (Session session = HibernateSessionUtil.getSession();){
            List<Project> projectsList = new ArrayList<>();
            for (final Object p : session.createQuery("from Project ").list()) {
                projectsList.add((Project) p);
            }
            return projectsList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean updateProjectName(int projectID) {
        return false;
    }
}
