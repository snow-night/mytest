package dailytest.compute;

import java.util.concurrent.*;


import dailytest.utils.ArraySplit;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-26 下午4:35
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        long start_single = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        long end_single = System.currentTimeMillis();

        System.out.println("单线程——和|时间：" + sum + "|" + (end_single - start_single));

        long start_double = System.currentTimeMillis();

        Object[] splits = ArraySplit.splitAry(arr, 5000000);

        long start_double1 = System.currentTimeMillis();
        Sumclass sm1 = new Sumclass((int[])(splits[0]));
        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println("时间点1：" + System.currentTimeMillis());
        Future f = es.submit(sm1);
        int[] arr2 = (int[]) (splits[1]);
//        Future future2 = es.submit(sm2);
        int result2 = 0;
        System.out.println("时间点2：" + System.currentTimeMillis());
        for (int i = 0; i < arr2.length; i++) {
            result2 += arr2[i];
        }
        System.out.println("时间点3：" + System.currentTimeMillis());
        try {
            Integer result1 = (Integer) f.get();
            System.out.println("时间点4：" + System.currentTimeMillis());
//            Integer result2 = (Integer)future2.get();
            System.out.println("加和结果：" + result1 + "|" + result2);
            System.out.println("双线程总和："+(result1+result2));

        } catch (InterruptedException e) {
            e.printStackTrace();
            f.cancel(true);

        } catch (ExecutionException e) {
            e.printStackTrace();
            f.cancel(true);
        }
        es.shutdownNow();

        long end_double = System.currentTimeMillis();

        System.out.println("双线程耗时：" + (end_double - start_double));


    }
}

class Sumclass implements Callable {

    private int[] arr;

    public Sumclass() {
    }

    public Sumclass(int[] arr) {
        this.arr = arr;
    }

    public Integer call() throws Exception {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
