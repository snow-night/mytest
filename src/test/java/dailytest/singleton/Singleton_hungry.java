package dailytest.singleton;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-16 下午4:28
 */
public class Singleton_hungry {
//    private Singleton(){}
//    private static class Inner{
//        private static final Singleton s = new Singleton();
//    }
//
//    public static final Singleton getInstance(){
//        return Inner.s;
//    }

    private static Singleton_hungry s = new Singleton_hungry();
    private Singleton_hungry(){}

    public static Singleton_hungry getInstance(){
        return s;
    }
}