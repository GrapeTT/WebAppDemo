package com.tao.controller;

import com.tao.domain.User;
import com.tao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.tao.tools.MD5Encrypt;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author：涛
 * @Descripition：
 * @Date：2018/3/19 22:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpSession session, User user) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String username = user.getUsername();
        String password = user.getPassword();
        if(username == null || username.equals("") || password == null || password.equals("")){
            modelAndView.addObject("error", "用户名或密码不能为空!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        MD5Encrypt md5 = new MD5Encrypt();
        password = md5.getMD5ofStr(password);
        User u = userService.selectUserByUsername(username);
        if(u == null || !u.getPassword().equals(password)){
            modelAndView.addObject("error", "用户名或密码错误!");
            modelAndView.setViewName("login");
        } else {
            session.setAttribute("username", username);
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }

    @RequestMapping(value = "/getRegister", method = RequestMethod.GET)
    public ModelAndView getRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    // 在需要校验的domain前边添加@Validated，在需要校验的domain后边添加BindingResult
    // bindingResult接收校验出错信息
    // 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    // Validated(value={xxx.class})指定使用xxx分组的校验
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, HttpServletRequest request, HttpSession session, @Validated User user, BindingResult bindingResult) throws Exception {
        // 获取校验错误信息
        if (bindingResult.hasErrors()) {
            // 输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            // 将错误信息传到页面
            model.addAttribute("allErrors", allErrors);
            //可以直接使用model将提交domain回显到页面
            model.addAttribute("user", user);
            // 出错重新到注册页面
            return "register";
        }

        String password = user.getPassword();
        MD5Encrypt md5 = new MD5Encrypt();
        password = md5.getMD5ofStr(password);
        user.setPassword(password);
        userService.insertUser(user);
        session.setAttribute("username", user.getUsername());

        return "home";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        //文件原始名称
        String originalFilename = file.getOriginalFilename();
        //上传文件
        if(file != null && originalFilename != null && originalFilename.length() > 0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //存储文件的物理路径
            String filePath = "D:\\Program Files\\Apache Software Foundation\\apache-tomcat-7.0.82\\upload\\images\\" + simpleDateFormat.format(new Date());
            //判断文件目录是否存在，若不存在，则创建
            if(!new File(filePath).exists()){
                new File(filePath).mkdirs();
            }
            filePath = filePath + "\\";
            //新文件名字
            String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新文件
            File newFile = new File(filePath + newFilename);
            //将内存中的数据写入磁盘
            file.transferTo(newFile);
            return "uploadSuccess";
        }
        return "uploadError";
    }
}
