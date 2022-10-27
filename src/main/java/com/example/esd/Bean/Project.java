package com.example.esd.Bean;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="project_id", nullable = false)
    private int projectID;

    @Column(name= "project_name")
    private String projectName;

//    @ManyToMany
//    private List<Employee> employeesList;


}
