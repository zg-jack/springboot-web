package com.zhuguang.jack.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.zhuguang.jack.servlet.JackServlet;

/** 
 *  往期视频加小露老师QQ：1533922121
 *  Jack老师QQ： 2943489129
 *  时间   ：     2017年12月26日 下午8:22:58 
 *  作者   ：   烛光学院【Jack老师】
 *  
 *  这个类是springboot工程的启动类
 *  
 *  @ComponentScan  这个注解就代表springboot工程需要支持注解 @Autowired  @Service @Resource @Qulifier
 *  @EnableAutoConfiguration  springboot很智能，根据启动器去判断是否需要初始化，省了很多以前spring的配置
 *  @Configuration 这个其实就是对应的spring里面的xml配置
 */

@SpringBootApplication(scanBasePackages = {"com.zhuguang.jack"})
@ServletComponentScan(basePackages = {"com.zhuguang.jack"})
//这个@MapperScan注解是springboot和mybatis整合时需要用的注解，这个注解会扫描dao层
@MapperScan("com.zhuguang.jack.dao")
public class SpringBootSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new JackServlet(), "/jack/*");
    }
}
