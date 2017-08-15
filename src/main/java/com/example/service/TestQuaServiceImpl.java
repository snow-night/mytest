package com.example.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestQuaServiceImpl implements TestQuaService{

    Logger logger = LoggerFactory.getLogger(TestQuaServiceImpl.class);

    @Override
    public void say() {
        logger.info("this is {}",this.toString());
    }
}
