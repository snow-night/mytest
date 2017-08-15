package dailytest.springjunit;


import com.example.vo.MailVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestMailVo {

    @Test
    public void test(){
        MailVo vo = new MailVo();
        System.out.println(vo.getAddress());
    }

}
