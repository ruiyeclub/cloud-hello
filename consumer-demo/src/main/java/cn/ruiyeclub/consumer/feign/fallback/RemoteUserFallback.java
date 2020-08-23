package cn.ruiyeclub.consumer.feign.fallback;

import cn.ruiyeclub.consumer.entity.User;
import cn.ruiyeclub.consumer.feign.RemoteUserService;
import org.springframework.stereotype.Component;

/**
 * user服务降级类 当请求超时或者服务停掉时 会被降级到这里来
 * @author Ray。
 * @date 2020/8/22 19:11
 */
@Component
public class RemoteUserFallback implements RemoteUserService {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户异常");
        return user;
    }

}
