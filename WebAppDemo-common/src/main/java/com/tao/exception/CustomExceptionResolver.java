package com.tao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Name：CustomExceptionResolver
 * @Package：com.tao.exception
 * @Descripition：全局异常处理器
 * @Author：涛
 * @Date：2018/4/7 14:16
 * @Version：1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CustomException customException = null;
        if(ex instanceof CustomException){
            customException = (CustomException)ex;
        } else {
            customException = new CustomException("服务器发生未知错误！");
        }
        String error = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
