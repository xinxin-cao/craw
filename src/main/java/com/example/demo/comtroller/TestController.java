package com.example.demo.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoyaxin
 * @date 2019-10-10-18:25
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "123123123";
    }
}
