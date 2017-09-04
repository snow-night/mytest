package dailytest.mytest;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lidongliang on 2017/8/16.
 */
public class TestDemo {

    String name;
    Integer age;
    List<Date> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Date> getList() {
        return list;
    }

    public void setList(List<Date> list) {
        this.list = list;
    }


    /**
     * 计算两个日期相差月数，包含边界
     * 格式 yyyyMMdd
     *
     * @param date1 <String>
     * @param date2 <String>
     * @return int
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result) + 1;

    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, JsonProcessingException {

    }
}
