package com.example.demo.mapper;

import com.example.demo.model.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caoyaxin
 * @date 2019-10-12-13:49
 */
@Mapper
public interface ProjectMapper {

    int insert(Project project);

}
