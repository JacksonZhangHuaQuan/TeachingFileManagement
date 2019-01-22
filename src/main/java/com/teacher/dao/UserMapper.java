package com.teacher.dao;

import com.teacher.entity.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);
    int deleteUser(User user);
    int updateUser(User user);
    User findUserById(Long id);
    List<User> findAllUser();
}
