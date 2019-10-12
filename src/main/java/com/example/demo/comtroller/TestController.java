package com.example.demo.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoyaxin
 * @date 2019-10-10-18:25
 */
@RestController
public class TestController {

    @Autowired(required = false)
    private ProjectMapper projectMapper;

    @GetMapping("hello")
    public String hello(){
        return "123123123";
    }

    @PostMapping("addProject")
    public JSONObject addProject(Project project){

        JSONObject json = new JSONObject();

        int row = projectMapper.insert(project);
        if(row > 0){
            json.put("code",200);
            json.put("msg","OK");
        }else {
            json.put("code",400);
            json.put("msg","FAIL");
        }
        return json;
    }
}
