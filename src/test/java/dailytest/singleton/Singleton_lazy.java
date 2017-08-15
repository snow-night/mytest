package dailytest.singleton;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-20 上午12:28
 */
public class Singleton_lazy {
    private Singleton_lazy(){}
    private static class Inner{
        private static final Singleton_lazy s = new Singleton_lazy();
    }

    public static final Singleton_lazy getInstace(){
        return  Inner.s;
    }
}
