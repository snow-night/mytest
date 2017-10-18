package dailytest.mytest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


import com.example.vo.Person;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-10-19 上午1:05
 */
public class TestEquals {
    public static <T> Map<String, String> compare(T obj1, T Obj2)
            throws Exception {

        Map<String, String> result = new HashMap<String, String>();

        Field[] fs = obj1.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            Object v1 = f.get(obj1);
            Object v2 = f.get(Obj2);
            result.put(f.getName(), String.valueOf(equals(v1, v2)));
        }
        return result;
    }

    public static boolean equals(Object obj1, Object obj2) {

        if (obj1 == obj2) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("李白",18);
        Person p2 = new Person("李白",18);
        Person p3 = new Person("李白",13);
        Map<String, String> result = compare(p1, p2);
        System.out.println(result);
    }
}
