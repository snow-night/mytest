package dailytest.function;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-21 下午5:11
 * <p>
 * 一个字符串  里面是单词和空格  要求顺序颠倒  但是单词字母还是原顺序
 * <p>
 * 例如：
 * my name    is   Lee
 * -->
 * Lee   is    name my
 */
public class MoveString {

    public static String move(String str) {
        String new_str = new String();
        StringBuffer sb = new StringBuffer();

        for(int i = str.length()-1;i>=0;i--){


            if(!" ".equals(String.valueOf(str.charAt(i)))){
                sb.append(str.charAt(i));
            }else{
                StringBuffer reverse = sb.reverse();
                new_str = new_str + reverse.toString()+" ";
                sb = new StringBuffer();
            }
            if(i==0){
                new_str = new_str + sb.reverse().toString();
            }
        }

        return new_str;
    }

    public static void main(String[] args) {
        System.out.println(move(" my name    is   Lee"));

    }

}
