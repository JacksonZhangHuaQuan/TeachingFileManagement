package com.teacher.service.impl;

import com.teacher.common.ServerResponse;
import com.teacher.dao.UserInfoMapper;
import com.teacher.dao.UserMapper;
import com.teacher.entity.User;
import com.teacher.entity.UserInfo;
import com.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public ServerResponse<User> login(User user) {
        String username = user.getUsername();
        User userCheck = userMapper.findByUsername(username);
        if (userCheck == null ){
          return ServerResponse.createError("用户名不存在!");
        }
        User currentUser = userMapper.selectLogin(user);
        if (currentUser == null){
            return ServerResponse.createError("密码错误");
        }
        currentUser.setPassword("");
        return ServerResponse.createSuccess("登录成功!",currentUser);
    }

    @Override
    public ServerResponse register(User user) {
        User userCheck = userMapper.findByUsername(user.getUsername());
        if (userCheck == null){
            int num = userMapper.addNormalUser(user);
            if (num > 0){
                return ServerResponse.createSuccessMessage("注册成功!");
            }
            return ServerResponse.createError("注册失败!");
        }
        return ServerResponse.createError("用户名已存在!");
    }

    @Override
    public ServerResponse<UserInfo> findInfoByUserId(Long userId) {
        UserInfo userInfo = userInfoMapper.findByUserId(userId);
        if ( userInfo == null ){
            return ServerResponse.createError("用户信息不存在！");
        }
        return ServerResponse.createSuccess(userInfo);
    }

    @Override
    public ServerResponse addInfo(UserInfo userInfo) {
        int num = userInfoMapper.add(userInfo);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("添加成功！");
        }
        return ServerResponse.createError("添加失败！");
    }

    @Override
    public ServerResponse updateInfo(UserInfo userInfo) {
        int num = userInfoMapper.update(userInfo);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("更新成功！");
        }
        return ServerResponse.createError("更新失败！");
    }


}
