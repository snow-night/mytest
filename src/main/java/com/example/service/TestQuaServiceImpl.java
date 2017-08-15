package com.example.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class TestQuaServiceImpl implements TestQuaService{

    public Logger logger = LogManager.getLogger(TestQuaServiceImpl.class);

    @Override
    public void say() {
        logger.info("this is {}",this.toString());
    }
}
