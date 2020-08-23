package cn.ruiyeclub.user.feign;

import cn.ruiyeclub.user.config.FeignConfig;
import cn.ruiyeclub.user.entity.User;
import cn.ruiyeclub.user.feign.fallback.RemoteUserFallback;
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
     * 路径不能写错
     * @param id
     * @return
     */
    @GetMapping("user/{id}")
    User queryById(@PathVariable Long id);
}
