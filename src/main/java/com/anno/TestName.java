package com.anno;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@NameAnno(value="ABC")
public class TestName {

    public static  Logger logger = LoggerFactory.getLogger(TestName.class);


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        logger.info("this is log name={} info={} num={}",name,"-Hello-",1);
    }

    public static void main(String[] args) {


        TestName testName = new TestName();
        testName.setName("Lee");
        Class tClass = testName.getClass();
        NameAnno annotation =  (NameAnno)tClass.getAnnotation(NameAnno.class);
        System.out.println(annotation.value());



    }
}
