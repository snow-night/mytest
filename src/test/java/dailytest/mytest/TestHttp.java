package dailytest.mytest;

import java.util.HashMap;


import com.utils.HttpClientRequest;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-20 下午5:49
 */
public class TestHttp {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","名字");
        map.put("age","12");
        map.put("param","333");

        String s = null;
        try {
            s = HttpClientRequest.executeHttpPostRequest("http://127.0.0.1:8081/myproject/mytest", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
