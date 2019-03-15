package com.teacher.dao;

import com.teacher.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

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
    int delete(@Param("id") Long id);
    /**
     * 更新用户信息
     * @param userInfo
     * @return int
     */
    int update( UserInfo userInfo);

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserInfo
     */
    UserInfo findById(@Param("id") Long id);


    /**
     * 根据关联用户id查询其用户信息
     * @param userId
     * @return UserInfo
     */
    UserInfo findByUserId(@Param("userId") Long userId);

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    UserInfo findByName(@Param("teacherName") String teacherName);
}
