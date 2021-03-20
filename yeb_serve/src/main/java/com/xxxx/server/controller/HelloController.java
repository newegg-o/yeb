package com.xxxx.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 *
 * @author 呵呵厉害了
 *  2021/03/18 23:24
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/**";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/gaoji/**";
    }
}
