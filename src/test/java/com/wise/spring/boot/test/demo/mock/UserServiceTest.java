package com.wise.spring.boot.test.demo.mock;

import com.wise.spring.boot.test.demo.entity.User;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 用户服务 测试
 *
 * @author lingyuwang
 * @date 2020-06-09 23:15
 * @since 1.1.1.0
 */
public class UserServiceTest {

    @Test
    public void allTest() {
        // 创建mock对象
        UserService userService = mock(UserService.class);

        // 使用mock对象
        User user = new User();
        user.setId(1L);
        user.setUserName("Sam");
        user.setAge(20);

        // 实际不会真正调用其方法体
        userService.add(user);
        userService.findAll();
//        userService.delete(user);
        userService.findAll();

        // 验证行为（验证是否执行过 add 方法 ）
        verify(userService).add(user);

        // 验证行为（验证是否执行过 delete 方法 ）
        verify(userService).delete(user);
    }

}
