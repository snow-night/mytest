package dailytest.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-09 下午4:31
 */
public class Test_Single {
    public static void main(String[] args) {
//        String DemoSet = HttpClientUtils.httpGet("http://localhost:8080/getName").toString();
//        String DemoData = HttpClientUtils.httpGet("http://localhost:8080/getData").toString();
//        String SingleSet = HttpClientUtils.httpGet("http://localhost:8080/single/getName").toString();
//        String SingleData = HttpClientUtils.httpGet("http://localhost:8080/single/getData").toString();
//        System.out.println("End--DemoSet:" + DemoSet + "--" + "DemoData:" + DemoData + "--SingleSet：" + SingleSet + "--SingleData："+SingleData);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {

                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
