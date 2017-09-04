package com.example.service;

import com.example.dao.TestDao;
import com.example.vo.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lidongliang on 2017/9/4.
 */

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestDao testDao;

    @Transactional(rollbackFor = {RuntimeException.class,Exception.class})
    public int update() throws Exception{
        int i = testDao.updateTest();
        if (true) {
            throw new MyException("异常");
        }
        return i;
    }

}
