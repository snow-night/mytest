package com.example.controller;

import com.example.vo.MailVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-08 下午2:20
 */

@Controller
@RequestMapping("/")
//@Scope("prototype")
public class Demo {

//    private String name = "李白";
//    private String age = "18";

    private String name;
    private String age;

    private static final Logger logger = LogManager.getLogger("12345");

    @Autowired
    MailVo mailVo;

    public Demo() {
        System.out.println("-------Demo init------");
        logger.warn("Demo init name={} age={}",name,age);
    }

    public Demo(String name, String age) {
        this.name = name;
        this.age = age;

        System.out.println("name：" + name + "|age:" + age);
    }

    @RequestMapping("getData")
    @ResponseBody
    public String getDemo() {
        System.out.println("Demo名字：" + name + "|年龄：" + age);
        System.out.println("address:"+mailVo.getAddress());
        return "success";
    }

    @RequestMapping(value = "getName")
    @ResponseBody
    public String getName() {
        name = "诸葛亮";

        logger.info("log--name={}",name);

        return "{name=\"" + name + "\"}";
    }


}
