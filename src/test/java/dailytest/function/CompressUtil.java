package dailytest.function;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-21 下午3:23
 *
 *
 * 数据压缩
 * 注意：1.如果是1那么不写  2.需处理最后一位
 * 例如：
 * aaabbbcccdeefffg  ->  a3b3c3de2f3g
 */
public class CompressUtil {


    public static String getCompressString(String param) {

        //初始化时开头第一位字符
        String result = param.substring(0, 1);
        int length = param.length();
        int num = 1;

        for (int i = 0; i < length - 1; i++) {
            String result_tmp;
            if (param.substring(i, i + 1).equals(param.substring(i + 1, i + 2))) {
                num++;//相等情况下 数字累加
            } else {
                result_tmp = param.substring(i + 1, i + 2);
                if (num == 1) {
                    result = result + result_tmp;
                } else {
                    result = result + num + result_tmp;//不相等情况下 原结果+数字+新字母
                    num = 1;
                }
            }

            if (length == i + 2) {
                if (param.substring(i, i + 1).equals(param.substring(i + 1, i + 2))) {
                    result = result + num;
                }
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(getCompressString("aaabbbcccdeefffg"));
        System.out.println(getCompressString("abcdeeff"));
    }
}


