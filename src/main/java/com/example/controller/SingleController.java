package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-09 上午11:04
 */
@RequestMapping("/single")
public class SingleController {
    private String name;
    private String age;

    public SingleController(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @RequestMapping("getData")
    @ResponseBody
    public String getData(){
        System.out.println("Single名字：" + name + "|年龄：" + age);
        return "success";
    }

    @RequestMapping("getName")
    @ResponseBody
    public String getName() {
        name = "诸葛亮";
        return name;
    }

}
