package com.wise.spring.boot.test.demo.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

import java.util.ArrayList;

/**
 * 单元测试声明周期测试
 *
 * 一个测试类单元测试的执行顺序：
 * @BeforeClass –> @Before –> @Test –> @After –> @AfterClass
 *
 * 每一个测试方法的执行顺序：
 * @Before –> @Test –> @After
 *
 * @author lingyuwang
 * @date 2020-06-09 14:28
 * @since 1.1.1
 */
@Slf4j
public class LifeycleTest {

    private ArrayList testList;

    /**
     * 一个测试类中所有测试方法执行之前执行的方法，只执行一次，且方法必须为static的
     *
     * @author lingyuwang
     * @date 2020-06-09 14:41
     * @since 1.1.1
     */
    @BeforeClass
    public static void onceExecutedBeforeAll() {
        log.info("@BeforeClass: onceExecutedBeforeAll");
    }

    /**
     * 每个测试方法执行之前执行的方法
     *
     * @author lingyuwang
     * @date 2020-06-09 14:41
     * @since 1.1.1
     */
    @Before
    public void executedBeforeEach() {
        testList = new ArrayList();
        log.info("@Before: executedBeforeEach");
    }

    @Test
    public void EmptyCollection() {
        Assert.assertTrue(testList.isEmpty());
        log.info("@Test: EmptyArrayList");

    }

    /**
     * 测试方法，可以测试期望异常和超时时间
     *
     * @author lingyuwang
     * @date 2020-06-09 14:40
     * @since 1.1.1
     */
    @Test
    public void OneItemCollection() {
        testList.add("oneItem");
        Assert.assertEquals(1, testList.size());
        log.info("@Test: OneItemArrayList");
    }

    /**
     * 每个测试方法执行之后执行的方法
     *
     * @author lingyuwang
     * @date 2020-06-09 14:42
     * @since 1.1.1
     */
    @After
    public void executedAfterEach() {
        testList.clear();
        log.info("@After: executedAfterEach");
    }

    /**
     * 一个测试类中所有测试方法执行之后执行的方法，只执行一次，且方法必须为static的
     *
     * @author lingyuwang
     * @date 2020-06-09 14:42
     * @since 1.1.1
     */
    @AfterClass
    public static void onceExecutedAfterAll() {
        log.info("@AfterClass: onceExecutedAfterAll");
    }

}
