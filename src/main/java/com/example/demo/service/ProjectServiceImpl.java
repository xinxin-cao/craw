package com.example.demo.service;

import com.example.demo.mapper.ProjectMapper;
import com.example.demo.model.Project;
import com.example.demo.util.PageUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author caoyaxin
 * @date 2019-10-12-17:22
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired(required = false)
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findProjectList(HashMap<String, Object> params) {
        return projectMapper.loadPage(params);
    }

    @Override
    public int addProject(Project project) {
        return projectMapper.insertProject(project);
    }

    @Override
    public String findById(int id) {
        return projectMapper.selectById(id);
    }

}
