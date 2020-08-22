package cn.ruiyeclub.consumer.controller;

import cn.ruiyeclub.consumer.entity.User;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Ray。
 * @date 2020/8/9 14:50
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable Long id){
        //这里是直接将访问地址写死了
//        String url="http://localhost:9091/user/"+id;

        //在spring-cloud-common包中自带了ribbon 所以即使user-service是服务名 也
        // 可以直接通过服务名访问
        String url="http://user-service/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }

}
