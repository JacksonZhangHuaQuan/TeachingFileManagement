package com.teacher.controller;


import com.teacher.common.Const;
import com.teacher.common.ServerResponse;
import com.teacher.entity.User;
import com.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     *  用户登录
     * @param user
     * @param httpSession
     * @return
     */
    @PostMapping("/login")
    public String login( User user,HttpSession httpSession){
         ServerResponse<User> serverResponse = userService.login(user);
         if (serverResponse.isSuccess()){
             httpSession.setAttribute(Const.CURRENT_INFO,userService.findInfoByUserId(serverResponse.getData().getId()).getData());
             httpSession.setAttribute(Const.CURRENT_USER,serverResponse.getData());
             return "main/index";
         }
         return "main/error";
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public ServerResponse register(@RequestBody User user){
        if( Const.UserType.TYPE_ADMIN == user.getType()){
            return userService.register(user);
        }
        return ServerResponse.createError("无权限！");
    }

}
