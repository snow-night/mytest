package com.example.controller;


import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-20 下午5:34
 */

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("mytest")

    public @ResponseBody
    String test(HttpServletRequest request){
//        TestVo testVo = testDao.selectOne();
//        System.out.println(new ObjectMapper().writeValueAsString(testVo));

        try {
            int update = testService.update();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }


}

