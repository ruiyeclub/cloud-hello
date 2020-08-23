package cn.ruiyeclub.consumer.controller;

import cn.ruiyeclub.user.entity.User;
import cn.ruiyeclub.user.feign.RemoteUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试cloud-api
 * @author Ray。
 * @date 2020/8/22 18:39
 */
@RestController
@RequestMapping("/cf")
public class RemoteConsumerController {

    @Resource
    private RemoteUserService remoteUserService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return remoteUserService.queryById(id);
    }
}
