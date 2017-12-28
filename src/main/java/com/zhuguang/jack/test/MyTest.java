package com.zhuguang.jack.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zhuguang.jack.service.CommonService;
import com.zhuguang.jack.start.SpringBootSampleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
//这个注解必须告诉junit，springboot的启动类是哪一个
@SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
//这个是junit需要模拟一个ServletContext
@WebAppConfiguration
public class MyTest {
    
    @Autowired
    CommonService commonService;
    
    @Test
    public void test1() {
        System.out.println(commonService.queryContent());
    }
}
