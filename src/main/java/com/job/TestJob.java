package com.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);

    public void job(){
        logger.info("....job.....");
    }

}
