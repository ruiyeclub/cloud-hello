package cn.ruiyeclub.consumer.controller;

import cn.ruiyeclub.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("{id}")
    public User queryById(@PathVariable Long id){
        String url="http://localhost:9091/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }
}
