package cn.ruiyeclub.consumer.controller;

import cn.ruiyeclub.consumer.entity.User;
import cn.ruiyeclub.consumer.feign.FeignUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ray。
 * @date 2020/8/22 18:39
 */
@RestController
@RequestMapping("/cf")
public class FeignConsumerController {

    @Resource
    private FeignUserService feignUserService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return feignUserService.queryById(id);
    }
}
