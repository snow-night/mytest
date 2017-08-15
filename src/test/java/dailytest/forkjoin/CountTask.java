package dailytest.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-27 上午10:51
 */

public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 500000;//阈值
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {

        System.out.println("线程id:"+Thread.currentThread().getId());
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待子任务执行外，并得到其结果
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }


        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(1, 1000000);
        //执行一个任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println("结果："+result.get());

            long end = System.currentTimeMillis();
            System.out.println("时间："+(end-start));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
