package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-08 上午12:58
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    //映射一个action
    @RequestMapping("/index")
    public String index() {
        //输出日志文件
        logger.info("the first jsp pages");
        System.out.println("______________index_____________");
        //返回一个index.jsp这个视图
        return "index";
    }
}