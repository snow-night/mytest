package dailytest.function;

import java.util.Arrays;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-30 上午10:45
 * <p>
 * 冒泡排序
 */
public class MPSort {

    public static int[] sort(int[] arr) {
        int tmp;

//        for (int i = arr.length - 1; i > 0; i--) {
//
//            for (int m = 0; m < i; m++) {
//
//                if (arr[m] > arr[m + 1]) {
//
//                    tmp = arr[m + 1];
//                    arr[m + 1] = arr[m];
//                    arr[m] = tmp;
//                }
//            }
//        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int m = 0; m < i; m++) {
                if (arr[m] > arr[m + 1]) {
                    tmp = arr[m];
                    arr[m] = arr[m + 1];
                    arr[m + 1] = tmp;
                }
            }
        }


        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 0, 3, 7, 8, 6};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
