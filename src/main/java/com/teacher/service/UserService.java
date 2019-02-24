package com.teacher.service;

import com.teacher.common.ServerResponse;
import com.teacher.entity.User;
import com.teacher.entity.UserInfo;

public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    ServerResponse<User> login(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    ServerResponse register(User user);

    /**
     * 查询用户个人信息
     * @param userId
     * @return
     */
    ServerResponse<UserInfo> findInfoByUserId(Long userId);

    /**
     * 添加用户信息
     * @param userInfo
     * @return
     */
    ServerResponse addInfo(UserInfo userInfo);

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    ServerResponse updateInfo(UserInfo userInfo);
}
