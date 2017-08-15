package dailytest.mytest;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class TestArrayUtils {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};

        System.out.println(Arrays.toString(ints));
        String s = ArrayUtils.toString(ints);
        System.out.println(s);
    }
}
