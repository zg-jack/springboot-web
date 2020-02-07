package com.zhuguang.jack.start;

import com.zhuguang.jack.druidConfig.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.zhuguang.jack"})
@MapperScan("com.zhuguang.jack.dao")
//@ServletComponentScan(basePackages = {"com.zhuguang.jack"})
@EnableConfigurationProperties(DruidConfig.class)
public class SpringbootTest {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootTest.class,
                args);
    }
}
