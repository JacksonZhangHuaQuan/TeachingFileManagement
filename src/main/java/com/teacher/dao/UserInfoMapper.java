package com.teacher.dao;

import com.teacher.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    /**
     * 添加用户信息
     * @param userInfo
     * @return int
     */
    int add( UserInfo userInfo);

    /**
     * 根据id删除用户信息
     * @param id
     * @return int
     */
    int delete(Long id);
    /**
     * 更新用户信息
     * @param userInfo
     * @return int
     */
    int update(UserInfo userInfo);

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
    UserInfo findById(Long id);


    /**
     * 根据关联用户id查询其用户信息
     * @param userId
     * @return UserInfo
     */
    UserInfo findByUserId(Long userId);
}
