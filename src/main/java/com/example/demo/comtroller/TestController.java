package com.example.demo.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.util.JsoupUtil;
import com.example.demo.util.PageUtil;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caoyaxin
 * @date 2019-10-10-18:25
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired(required = false)
    private ProjectService projectService;

    @Value("${project.url}")
    private String projectUrl;

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("runUrl/{id}")
    @ResponseBody
    public String runUrl(@PathVariable int id){
        String testUrl = projectService.findById(id);
        return JsoupUtil.getUrl(projectUrl+testUrl);
    }

    @GetMapping("list")
    public String list(@RequestParam Map<String, String> map, Model model){

        HashMap<String,Object> params = new HashMap<>();
        if(map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "0");
        }
        // 查询用户列表 及设置分页信息
        List<Project> projectList = projectService.findProjectList(params);
        // 参数为当前页码、每页显示条数、查询的列表集合
        PageUtil pageInfo = new PageUtil(Integer.valueOf(map.get("currentPage")), 20, projectList);
        model.addAttribute("projectList", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);

        return "list";
    }

    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("name","maozong");
        return "add";
    }

    @PostMapping("addProject")
    @ResponseBody
    public JSONObject addProject(Project project){

        JSONObject json = new JSONObject();

        int row = projectService.addProject(project);
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
