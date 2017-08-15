package dailytest.function;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-03 上午10:44
 * <p>
 * 二分查找
 */
public class BinarySearch {


    public static int search(Integer[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int middle = (high + low) / 2;
            if (des == arr[middle]) {
                return middle;
            } else if (des < middle) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(6);
        set.add(8);
        set.add(2);
        set.add(4);
        set.add(3);
        set.add(9);

        Integer[] arr = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(arr));

        int search = search(arr, 5);
        System.out.println(arr[search]);
    }
}
