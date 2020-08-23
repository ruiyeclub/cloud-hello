package cn.ruiyeclub.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign日志级别配置类
 * @author Ray。
 * @date 2020/8/22 19:21
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        //记录所有请求和响应的明细
        return Logger.Level.FULL;
    }
}
