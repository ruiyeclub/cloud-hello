package cn.ruiyeclub.user.service;

import cn.ruiyeclub.user.entity.User;

public interface UserService {


    /**
     * 根据主键查询用户
     * @param id 用户id
     * @return 用户
     */
    User queryById(Long id);
}
