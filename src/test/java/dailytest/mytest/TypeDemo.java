package dailytest.mytest;

/**
 * Created by lidongliang on 2017/8/16.
 */
public class TypeDemo {

    public<T> T getType( T t){
        return t;
    }

    public static void main(String[] args) {
//        TypeDemo d = new TypeDemo();
//        String abc = d.getType("abc");
//        System.out.println(abc);
        System.out.println(TypeDemo.class.getResource("/"));
        System.out.println(TypeDemo.class.getResource(""));

    }
}


