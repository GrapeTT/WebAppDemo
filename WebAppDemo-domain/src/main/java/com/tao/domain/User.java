package com.tao.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author：涛
 * @Descripition：
 * @Date：2018/3/19 11:20
 */
public class User implements Serializable {

    private Integer id;

    //message：提示检验出错显示的信息
    //groups：此校验属于哪个分组，可以定义多个分组（groups = {xxx.class}）
    //校验用户名在1到16字符之间
    @NotBlank(message = "{error.user.username.isNull}")
    @Size(min = 1, max = 16, message = "{error.user.username.sizeError}")
    @Pattern(regexp="[a-z0-9A-Z]*", message="{error.user.username.formatError}")
    private String username;

    @NotBlank(message = "{error.user.password.isNull}")
    @Size(min = 6, max = 20, message = "{error.user.password.sizeError}")
    @Pattern(regexp="[a-z0-9A-Z.@]*", message="{error.user.password.formatError}")
    private String password;

    private String realname;

    @Pattern(regexp="[男女]", message="{error.user.sex.formatError}")
    private String sex;

    private String grade;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "{error.user.email.formatError}")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = "".equals(username) ? null : username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "".equals(password) ? null : password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = "".equals(realname) ? null : realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = "".equals(sex) ? null : sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = "".equals(grade) ? null : grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = "".equals(email) ? null : email;
    }
}
