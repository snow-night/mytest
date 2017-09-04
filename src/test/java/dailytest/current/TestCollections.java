package dailytest.current;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lidongliang on 2017/8/17.
 */
public class TestCollections {
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    private static List<Integer> list = new Vector<>();


    public static void main(String[] args) throws ParseException, InterruptedException {
//        System.out.println(DateUtils.dateToString(new Date(),DateUtils.DATE_SHORT_PATTERN));
//        System.out.println(new Date());

        final Collection<Integer> collection = Collections.synchronizedCollection(list);
        final CountDownLatch countDownLatch = new CountDownLatch(200);

        for(int i = 0;i<200;i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for(int a=1;a<=10;a++){
                        collection.add(a);
                    }
                    System.out.println(Thread.currentThread().getName()+"-线程添加完毕");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println("size: "+list.size()+"|coll.size: "+collection.size());
    }
}
