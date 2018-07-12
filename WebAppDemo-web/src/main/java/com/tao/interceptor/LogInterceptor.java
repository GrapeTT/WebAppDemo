package com.tao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Name：LogInterceptor
 * @Package：com.tao.interceptor
 * @Descripition：
 * @Author：涛
 * @Date：2018/4/9 10:33
 * @Version：1.0
 */
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(username != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String log = simpleDateFormat.format(new Date()) + "：";
            log = log + "用户 " + username;
            String url = request.getRequestURI();
            if(url.indexOf("login") >= 0){
                log = log + " 登录系统";
            } else if(url.indexOf("logout") >= 0){
                session.invalidate();
                log = log + " 退出系统";
            }
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String filePath = "D:\\Program Files\\Apache Software Foundation\\apache-tomcat-7.0.82\\WebAppDemo\\logs\\" + simpleDateFormat.format(new Date()) + ".txt";
            File file = new File(filePath);
            FileWriter fileWriter = null;
            if(!file.exists()){
                file.createNewFile();
                fileWriter = new FileWriter(file, true);
            } else {
                fileWriter = new FileWriter(file, true);
                fileWriter.write("\n");
            }
            fileWriter.write(log);
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
