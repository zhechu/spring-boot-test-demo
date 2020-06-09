package com.wise.spring.boot.test.demo.simple;

import org.junit.Test;

/**
 * 其它 测试
 *
 * @author lingyuwang
 * @date 2020-06-09 16:56
 * @since 1.1.1.0
 */
public class OtherTest {

    /**
     * 抛出异常测试
     *
     * @author lingyuwang
     * @date 2020-06-09 16:58
     * @since 1.1.1.0
     */
    @Test(expected = ArithmeticException.class)
    public void exceptionTest() {
        int i = 1 / 0;
    }

    /**
     * 测试运行时间是否超过指定的毫秒数，若超过则终止并标记为失败
     *
     * @author lingyuwang
     * @date 2020-06-09 16:59
     * @since 1.1.1.0
     */
    @Test(timeout = 1000)
    public void timeoutTest() {
        while (true) {
            // do nothing.
        }
    }

}
