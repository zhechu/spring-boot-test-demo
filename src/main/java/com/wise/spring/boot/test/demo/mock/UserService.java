package com.wise.spring.boot.test.demo.mock;

import com.wise.spring.boot.test.demo.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务
 *
 * @author lingyuwang
 * @date 2020-06-09 23:24
 * @since 1.1.1.0
 */
@Slf4j
public class UserService {

    private List<User> userList = new ArrayList<>();

    public void add(User user) {
        userList.add(user);
        log.info("add user:{}", user);
    }

    public void delete(User user) {
        userList.remove(user);
        log.info("delete user:{}", user);
    }

    public List<User> findAll() {
        log.info("find all user:{}", userList);
        return userList;
    }

}
