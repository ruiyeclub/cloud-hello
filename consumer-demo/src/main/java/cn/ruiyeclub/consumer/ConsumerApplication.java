package cn.ruiyeclub.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ray。
 * @date 2020/8/9 14:48
 */
//@SpringBootApplication
//@EnableDiscoveryClient //开启Eureka客户端发现功能
//@EnableCircuitBreaker //开启熔断

@SpringCloudApplication //这个注解就包括上面三个
@EnableFeignClients //开启Feign功能
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    /**
     * 负载均衡注解
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
