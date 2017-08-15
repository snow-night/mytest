package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.example.vo.Person;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-21 上午12:33
 */
@Controller
public class PersonController {

    /**
     * 查询个人信息
     *
     * @return
     */
    @RequestMapping(value = "/person/profile/{name}/{age}", method = RequestMethod.GET)
    public @ResponseBody
    Person porfile(@PathVariable String name,
                   @PathVariable int age) {
        return new Person(name, age);
    }

    /**
     * 登录
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "/person/login", method = RequestMethod.POST)
    public @ResponseBody
    Person login(@RequestBody Person person) {
        return person;
    }
}
