package com.example.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestQuaServiceImplCopy implements TestQuaService{

    Logger logger = LoggerFactory.getLogger(TestQuaServiceImplCopy.class);

    @Override
    public void say() {
        logger.info("this is {}",this.toString());
    }
}
