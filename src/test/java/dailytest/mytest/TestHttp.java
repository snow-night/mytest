package dailytest.mytest;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.LogManager;


import com.utils.HttpClientRequest;
import org.apache.logging.log4j.Logger;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-20 下午5:49
 */
public class TestHttp {

    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger("12345");


    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("name","名字");
        map.put("age","12");
        map.put("param","333");

        logger.info("haha,{}","123","哈哈");

        String s = null;
//        try {
//            s = HttpClientRequest.executeHttpPostRequest("http://127.0.0.1:8081/myproject/mytest", map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(s);

        Date date = new Date();

        System.out.println();
    }
}
