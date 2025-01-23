package com.ssamz.jblog;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootTest
class JBlogWebApplicationTests {

	@Test
	void contextLoads() {
	}
	
	private static final Logger logger = LoggerFactory.getLogger(JBlogWebApplicationTests.class);

    @GetMapping("/test")
    public String testLog() {
        String message = "한글 데이터 테스트입니다!";
        logger.info(message); // 로그 출력
        return message; // HTTP 응답
    }

}
