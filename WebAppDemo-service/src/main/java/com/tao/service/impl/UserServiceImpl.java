package com.tao.service.impl;

import com.tao.domain.User;
import com.tao.domain.UserPackage;
import com.tao.service.UserService;
import com.tao.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：涛
 * @Descripition：
 * @Date：2018/3/23 16:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    //通过Id查询用户信息
    @Override
    public User selectUserById(Integer id) throws Exception {
        return userDao.selectUserById(id);
    }

    //通过Username查询用户信息
    @Override
    public User selectUserByUsername(String username) throws Exception {
        return userDao.selectUserByUsername(username);
    }

    //通过年级的列表查询所有用户信息
    @Override
    public List<User> selectUserByGrades(UserPackage userPackage) throws Exception {
        return userDao.selectUserByGrades(userPackage);
    }

    //增加用户
    @Override
    public void insertUser(User user) throws Exception {
        userDao.insertUser(user);
    }

    //通过username删除用户
    @Override
    public void deleteUserByUsername(String username) throws Exception {
        userDao.deleteUserByUsername(username);
    }

    //更新用户信息
    @Override
    public void updateUser(UserPackage userPackage) throws Exception {
        userDao.updateUser(userPackage);
    }
}
