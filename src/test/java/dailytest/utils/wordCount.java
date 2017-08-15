package dailytest.utils;

import java.util.*;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-11 上午11:20
 */
public class wordCount {
    public static void main(String arg[]){
        int wordCount=0;      //用于统计单词的总个数
        Map<String,Integer> map=new HashMap<String,Integer>();//用于统计各个单词的个数，排序
        String sentence="hello,my name is Tom,what is your name?he said:\"my name is John\"";
        StringTokenizer token=new StringTokenizer(sentence);//这个类会将字符串分解成一个个的标记
        while(token.hasMoreTokens()){                      //循环遍历
            wordCount++;
            String word=token.nextToken(", ?.!:\"\"''\n");  //括号里的字符的含义是说按照,空格 ? . : "" '' \n去分割，如果这里你没明确要求，即括号里为空，则默认按照空格，制表符，新行符和回车符去分割
            if(map.containsKey(word)){     //HashMap不允许重复的key，所以利用这个特性，去统计单词的个数
                int count=map.get(word);
                map.put(word, count+1);     //如果HashMap已有这个单词，则设置它的数量加1
            }
            else
                map.put(word, 1);          //如果没有这个单词，则新填入，数量为1
        }
        System.out.println("总共单词数："+wordCount);
        sort(map);                        //调用排序的方法，排序并输出！
    }
    public static void sort(Map<String,Integer> map){
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        }); //排序
        for (int i = 0; i < infoIds.size(); i++) {   //输出
            Map.Entry<String, Integer> id = infoIds.get(i);
            System.out.println(id.getKey()+":"+id.getValue());
        }
    }
}
