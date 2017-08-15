package com.example.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TestQuaServiceImplCopy implements TestQuaService{

    Logger logger = LogManager.getLogger(TestQuaServiceImplCopy.class);

    @Override
    public void say() {
        logger.info("this is {}",this.toString());
    }
}
