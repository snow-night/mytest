package dailytest.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-26 下午4:50
 */
public class ArraySplit {
    /**
     * 2014-8-4 上午10:39:28
     * @param args
     *
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] ary = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};//要分割的数组
        int splitSize = 3;//分割的块大小
        Object[] subAry = splitAry(ary, splitSize);//分割后的子块数组
        for(Object obj: subAry){//打印输出结果
            int[] aryItem = (int[]) obj;
            for(int i = 0; i < aryItem.length; i++){
                System.out.print(aryItem[i] + ", ");
            }
            System.out.println();
        }

    }

    /**
     * splitAry方法<br>
     * 2014-8-4 上午10:45:36
     * @param ary 要分割的数组
     * @param subSize 分割的块大小
     * @return
     *
     */
    public static Object[] splitAry(int[] ary, int subSize) {
        int count = ary.length % subSize == 0 ? ary.length / subSize: ary.length / subSize + 1;

        List<List<Integer>> subAryList = new ArrayList<List<Integer>>();

        for (int i = 0; i < count; i++) {
            int index = i * subSize;
            List<Integer> list = new ArrayList<Integer>();
            int j = 0;
            while (j < subSize && index < ary.length) {
                list.add(ary[index++]);
                j++;
            }
            subAryList.add(list);
        }

        Object[] subAry = new Object[subAryList.size()];

        for(int i = 0; i < subAryList.size(); i++){
            List<Integer> subList = subAryList.get(i);
            int[] subAryItem = new int[subList.size()];
            for(int j = 0; j < subList.size(); j++){
                subAryItem[j] = subList.get(j).intValue();
            }
            subAry[i] = subAryItem;
        }

        return subAry;
    }
}
