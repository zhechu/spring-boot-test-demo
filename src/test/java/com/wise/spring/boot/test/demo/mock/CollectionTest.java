package com.wise.spring.boot.test.demo.mock;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * 集合 测试
 *
 * @author lingyuwang
 * @date 2020-06-09 23:15
 * @since 1.1.1.0
 */
public class CollectionTest {

    @Test
    public void listTest() {
        // 创建mock对象
        List mockedList = mock(List.class);

        // 使用mock对象
        mockedList.add("one");
        mockedList.clear();

        // 验证行为（验证是否执行过 add("one") ）
        verify(mockedList).add("one");

        // 验证行为（验证是否执行过 clear() ）
        verify(mockedList).clear();
    }

}
