package com.example.dao;

import com.common.SpringContextUtil;
import com.example.vo.TestVo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lidongliang on 2017/8/31.
 */

@Repository
public class TestDao {

    @Resource
    JdbcTemplate jdbcTemplate;

    public TestVo selectOne() {
        List<TestVo> testVos = jdbcTemplate.query("select * from test limit 1", new Object[]{}, new BeanPropertyRowMapper<TestVo>(TestVo.class));
        return testVos.get(0);
    }

    public int updateTest() {
        List<Integer> ips = jdbcTemplate.queryForList("select ip from test limit 1", Integer.class);
        int ip = ips.get(0) + 1;
        System.out.println("新ip=" + ip);
        String sql = "update test SET  ip = (" + ip + ") where id = 1";
        int update = jdbcTemplate.update(sql);


        return update;
    }

}
