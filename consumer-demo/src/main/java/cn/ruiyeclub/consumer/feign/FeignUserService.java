package cn.ruiyeclub.consumer.feign;

import cn.ruiyeclub.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign客户端里面可以使用MVC常用的注解
 * @author Ray。
 * @date 2020/8/22 18:35
 */
@FeignClient("user-service") //声明当前类是一个Feign客户端，指定服务名为user-service
public interface FeignUserService {

    /**
     * eg:http://user-service/user/1
     * @param id
     * @return
     */
    @GetMapping("user/{id}")
    User queryById(@PathVariable Long id);
}
