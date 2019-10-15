package com.example.demo.service;

import com.example.demo.model.Project;

import java.util.HashMap;
import java.util.List;

/**
 * @author caoyaxin
 * @date 2019-10-12-17:21
 */

public interface ProjectService {
    List<Project> findProjectList(HashMap<String,Object> params);

    int addProject(Project project);

    String findById(int id);
}
