package dailytest.mytest;

import java.lang.reflect.Field;


import com.example.vo.Person;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-09-20 下午11:21
 */
public class SoutFiled {
    public static void main(String[] args) {
        Field[] field = Person.class.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < field.length; i++) {
            sb.append(field[i].getName());
            if (i == (field.length - 1)) {
                break;
            }
            sb.append(",");
        }
        System.out.println(sb);
    }
}
