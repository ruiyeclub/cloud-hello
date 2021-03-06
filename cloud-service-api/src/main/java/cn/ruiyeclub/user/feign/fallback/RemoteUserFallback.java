package cn.ruiyeclub.user.feign.fallback;

import cn.ruiyeclub.user.entity.User;
import cn.ruiyeclub.user.feign.RemoteUserService;
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
