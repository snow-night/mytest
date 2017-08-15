package com.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    private static final Logger logger = LogManager.getLogger(TestJob.class);

    public void job(){
        logger.info("....job.....");
    }

}
