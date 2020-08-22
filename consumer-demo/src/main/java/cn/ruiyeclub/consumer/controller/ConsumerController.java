package cn.ruiyeclub.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@DefaultProperties(defaultFallback = "queryByIdFallBack")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    @HystrixCommand //开启服务降级
    public String queryById(@PathVariable Long id){
        //这里是直接将访问地址写死了
//        String url="http://localhost:9091/user/"+id;

        if(id==1){
            throw new RuntimeException("太忙了");
        }
        /**
         * 在spring-cloud-common包中自带了ribbon
         * 所以即使user-service是服务名 也可以直接通过服务名访问
         */
        String url="http://user-service/user/"+id;
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * 服务降级(触发条件 请求超过默认时间1s、报错 或者请求的服务关闭了)
     * @return
     */
    public String queryByIdFallBack(){
        return "对不起，网络拥挤！";
    }


}
