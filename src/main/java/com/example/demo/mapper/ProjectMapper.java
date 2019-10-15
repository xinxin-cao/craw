package com.example.demo.mapper;

import com.example.demo.model.Project;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * @author caoyaxin
 * @date 2019-10-12-13:49
 */
@Mapper
public interface ProjectMapper {

    int insertProject(Project project);


    Page<Project> loadPage(HashMap<String,Object> params);

    String selectById(int id);
}
