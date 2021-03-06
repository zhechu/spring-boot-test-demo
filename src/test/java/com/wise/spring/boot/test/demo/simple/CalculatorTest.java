package com.wise.spring.boot.test.demo.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * 计算器 测试
 *
 * @author lingyuwang
 * @date 2020-06-09 14:28
 * @since 1.1.1
 */
@Slf4j
public class CalculatorTest {

    @Test
    public void sumTest() {
        Calculator calculator = new Calculator();
        int actualSum = calculator.sum(2, 5);
        int expectedSum = 7;

        log.info("@Test sum(): {} = {}", actualSum, expectedSum);

        // 判断预期的值和实际的值是否相等，若不相等则会抛出 AssertionError 异常
        Assert.assertEquals(expectedSum, actualSum);
    }

}
