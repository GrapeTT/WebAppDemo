package com.tao.exception;

/**
 * @Name：CustomException
 * @Package：com.tao.exception
 * @Descripition：系统自定义的异常类，针对预期的异常，需要在程序中抛出此类的异常
 * @Author：涛
 * @Date：2018/4/7 14:06
 * @Version：1.0
 */
public class CustomException  extends Exception{
    //异常信息
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
