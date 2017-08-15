package dailytest.function;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-21 下午4:29
 * <p>
 * 打印菱形
 * |     *
 * |    ***
 * |   *****
 * |    ***
 * |     *
 */
public class OutRhombus {

    /**
     * 奇数num  总行数也为num  中间*数也为num
     * 星数=2*n-1
     * 空格数=(num - (2*n-1))/2
     *
     * @param num
     */
    public static void Out(Integer num) {

        //行数 n
        for (int n = 1; n <= num; n++) {

            if (n <= (num + 1) / 2) {

                for (int m = 1; m <= (num - (2 * n - 1)) / 2; m++) {
                    System.out.print(" ");
                }
                for (int m = 1; m <= 2 * n - 1; m++) {
                    System.out.print("*");
                }
                for (int m = 1; m <= (num - (2 * n - 1)) / 2; m++) {
                    System.out.print(" ");
                }
                System.out.println();
            } else {
                for (int m = 1; m <= (num - (2 * ((num + 1) - n) - 1)) / 2; m++) {
                    System.out.print(" ");
                }
                for (int m = 1; m <= 2 * ((num + 1) - n) - 1; m++) {
                    System.out.print("*");
                }
                for (int m = 1; m <= (2 * ((num + 1) - n) - 1) / 2; m++) {
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

    }


    public static void main(String[] args) {
        Out(7);
    }
}
