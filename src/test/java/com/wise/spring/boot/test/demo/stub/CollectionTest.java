package com.wise.spring.boot.test.demo.stub;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * 集合 测试
 *
 * @author lingyuwang
 * @date 2020-06-09 23:15
 * @since 1.1.1.0
 */
@Slf4j
public class CollectionTest {

    /**
     * 打桩测试
     *
     * @author lingyuwang
     * @date 2020-06-09 23:53
     * @since 1.1.1.0
     */
    @Test
    public void listTest() {
        // 可以 mock 具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 输出“first”
        log.info("mockedList.get(0):{}", mockedList.get(0));

        // 抛出异常
        log.info("mockedList.get(1):{}", mockedList.get(1));

        // 因为get(999) 没有打桩，因此输出null
        log.info("mockedList.get(999):{}", mockedList.get(999));

        // 验证get(0)被调用的次数
        verify(mockedList).get(0);
    }

    /**
     * 调用次数测试
     *
     * @author lingyuwang
     * @date 2020-06-09 23:52
     * @since 1.1.1.0
     */
    @Test
    public void callTimesTest() {
        // 可以 mock 具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 使用模拟对象
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        // 下面的两个验证函数效果一样,因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        // 验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        // 使用never()进行验证,never相当于times(0)
        verify(mockedList, never()).add("never happened");

        // 使用atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("five times");
        verify(mockedList, atMost(5)).add("three times");
    }

    /**
     * 为返回值为void的函数通过Stub抛出异常
     *
     * @author lingyuwang
     * @date 2020-06-09 23:52
     * @since 1.1.1.0
     */
    @Test
    public void throwExceptionTest() {
        // 可以 mock 具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        // 调用这句代码会抛出异常
        mockedList.clear();
    }

    /**
     * 验证执行执行顺序
     *
     * @author lingyuwang
     * @date 2020-06-09 23:55
     * @since 1.1.1.0
     */
    @Test
    public void orderTest() {
        // A. 验证mock一个对象的函数执行顺序
        // 创建Mock对象
        List singleMock = mock(List.class);

        // 使用mock对象
        singleMock.add("was added first");
        singleMock.add("was added second");

        // 为该mock对象创建一个inOrder对象
        InOrder inOrder = inOrder(singleMock);

        // 确保add函数首先执行的是add("was added first"),然后才是add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B .验证多个mock对象的函数执行顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        // 使用mock对象
        firstMock.add("was called first");
        secondMock.add("was called second");

        // 为这两个Mock对象创建inOrder对象
        inOrder = inOrder(firstMock, secondMock);

        // 验证它们的执行顺序
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }

}
