package com.example.esd.DAO;

import com.example.esd.Bean.Project;

import java.util.List;

public interface ProjectDAO {
    boolean addProject(Project projectObj);
    List<Project> getProjectList();
    boolean updateProjectName(int projectID,  String updatedName);
}
