package com.wise.spring.boot.test.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 指定测试类使用某个运行器
@SpringBootTest // 指定 Spring Boot 测试环境
@Slf4j
public class SpringBootTestDemoApplicationTest {

	@Test
	public void loadTest() {
		log.info("load success");
	}

}
