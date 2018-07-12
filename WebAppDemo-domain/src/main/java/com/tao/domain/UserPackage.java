package com.tao.domain;

import java.util.List;

/**
 * @Name：UserPackage
 * @Package：com.tao.domain
 * @Descripition：
 * @Author：涛
 * @Date：2018/3/26 16:43
 * @Version：1.0
 */
public class UserPackage{
    //原用户名
    private String oldUsername;

    private User user;

    //年级列表
    private List<String> grades;

    private List<User> users;

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
