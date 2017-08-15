package dailytest.proxy;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-06-20 上午12:39
 *
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {
    public void save() {
        System.out.println("save...");
    }
}
