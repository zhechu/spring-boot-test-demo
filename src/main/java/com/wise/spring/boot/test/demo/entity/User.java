package com.wise.spring.boot.test.demo.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 用户
 *
 * @author lingyuwang
 * @date 2020-06-09 23:25
 * @since 1.1.1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;

    String userName;

    Integer age;

}
