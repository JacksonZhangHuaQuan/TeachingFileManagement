package com.teacher.controller;


import com.alibaba.fastjson.JSON;
import com.teacher.common.Const;
import com.teacher.common.ServerResponse;
import com.teacher.entity.User;
import com.teacher.entity.UserInfo;
import com.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String login( User user,HttpSession httpSession,HttpServletRequest request){
         ServerResponse<User> serverResponse = userService.login(user);
         if (serverResponse.isSuccess() && serverResponse.getData().getType() == Const.UserType.TYPE_USER){
             httpSession.setAttribute(Const.CURRENT_INFO,userService.findInfoByUserId(serverResponse.getData().getId()).getData());
             httpSession.setAttribute(Const.CURRENT_USER,serverResponse.getData());
             return "main/index";
         }
         if (serverResponse.isSuccess() && serverResponse.getData().getType() == Const.UserType.TYPE_ADMIN){
             httpSession.setAttribute(Const.CURRENT_INFO,userService.findInfoByUserId(serverResponse.getData().getId()).getData());
             httpSession.setAttribute(Const.CURRENT_USER,serverResponse.getData());
             return "admin/index";
         }
        String json = JSON.toJSONString(serverResponse);
        request.setAttribute("serverResponse",json);
         return "/login";
    }

    @PostMapping("/userinfo")
    public String update(UserInfo userInfo, HttpServletRequest request,HttpSession httpSession){
        ServerResponse serverResponse=userService.updateInfo(userInfo);
        httpSession.setAttribute(Const.CURRENT_INFO,userService.findInfoByUserId(userInfo.getUserId()).getData());
        request.setAttribute("serverResponse",JSON.toJSONString(serverResponse));
        return "main/index";
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(User user,UserInfo userInfo,HttpServletRequest request){
        request.setAttribute("serverResponse",JSON.toJSONString(userService.register(user,userInfo)));
        return "admin/index";
    }

}
