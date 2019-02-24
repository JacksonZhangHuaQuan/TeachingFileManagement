package com.teacher.common;

public class Const {
    public static String CURRENT_USER = "currentUser";
    public static String CURRENT_INFO = "currentInfo";
    public interface UserType{
        /**
         * 普通用户
         */
        int   TYPE_USER = 0;
        /**
         * 管理员
         */
        int TYPE_ADMIN = 1;
    }
}
