package cn.ruiyeclub.user.service.impl;

import cn.ruiyeclub.user.entity.User;
import cn.ruiyeclub.user.mapper.UserMapper;
import cn.ruiyeclub.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ray。
 * @date 2020/8/8 18:49
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据主键查询用户
     * @param id 用户id
     * @return 用户
     */
    @Override
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
