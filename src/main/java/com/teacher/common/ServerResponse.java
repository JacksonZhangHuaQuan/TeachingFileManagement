package com.teacher.common;


public class ServerResponse<T> {
    private int status;
    private String message;
    private T data;

    public ServerResponse(int status) {
        this.status = status;
    }

    public ServerResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess(){
        if (this.status == ResponseCode.SUCCESS.getCode())
            return true;
        return false;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
    public static <T> ServerResponse<T> createSuccess(String message,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message,data);
    }
    public static <T> ServerResponse<T> createSuccessMessage(String message){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message);
    }
    public static <T> ServerResponse<T> createSuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),data);
    }
    public static <T> ServerResponse<T> createSuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public static <T> ServerResponse<T> createError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createError(String message){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),message);
    }
    public static <T> ServerResponse<T> createErrorCodeMessage(int code,String message){
        return  new ServerResponse<T>(code,message);
    }
}
