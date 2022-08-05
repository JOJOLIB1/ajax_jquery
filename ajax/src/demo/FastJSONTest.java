package demo;

import bean.User;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @className: demo.FastJSONTest
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-04 18:13
 */
public class FastJSONTest {
    public static void main(String[] args) {
        User zhangSan = new User("zhangSan");
        User liSI = new User("liSI");
        ArrayList<User> users = new ArrayList<>();
        users.add(zhangSan);
        users.add(liSI);
        String jsonString = JSON.toJSONString(users);
        System.out.println(jsonString);
    }
}
