package com.example.controller;

import com.example.service.TestQuaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/")
public class TestQualifierController implements InitializingBean{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("testQuaServiceImplCopy")
    private TestQuaService testQuaService;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("--- {} init ---",this.getClass());
        testQuaService.say();
    }

    @RequestMapping("testqua")
    public @ResponseBody
    String testqua() {

        testQuaService.say();
        System.out.println("呵呵");
        return "success";
    }
}
