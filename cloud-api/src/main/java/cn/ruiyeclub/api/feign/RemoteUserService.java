package cn.ruiyeclub.api.feign;

import cn.ruiyeclub.api.config.FeignConfig;
import cn.ruiyeclub.api.entity.User;
import cn.ruiyeclub.api.feign.fallback.RemoteUserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign客户端里面可以使用MVC常用的注解
 * @author Ray。
 * @date 2020/8/22 18:35
 */
@FeignClient(value = "user-service", fallback = RemoteUserFallback.class,configuration = FeignConfig.class) //声明当前类是一个Feign客户端，指定服务名为user-service
public interface RemoteUserService {

    /**
     * eg:http://user-service/user/1
     * @param id
     * @return
     */
    @GetMapping("user/{id}")
    User queryById(@PathVariable Long id);
}
