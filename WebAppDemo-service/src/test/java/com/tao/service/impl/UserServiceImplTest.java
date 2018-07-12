package com.tao.service.impl;

import com.tao.domain.User;
import com.tao.domain.UserPackage;
import com.tao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：涛
 * @Descripition：
 * @Date：2018/3/23 17:01
 */
@ContextConfiguration(
        locations={"classpath:spring/applicationContext-dao.xml",
                "classpath:spring/applicationContext-service.xml",
                "classpath:spring/applicationContext-transaction.xml",
                "classpath:spring/springmvc.xml",
                "classpath:mybatis/SqlMapConfig.xml"
        })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
public class UserServiceImplTest {

    /*@Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Spy
    private User user;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }*/

    @Autowired
    private UserService userService;

    @Test
    public void selectUserByGrades() throws Exception {
        List<String> grades = new ArrayList<String>();
        grades.add("2015");
        grades.add("2016");
        UserPackage userPackage = new UserPackage();
        userPackage.setGrades(grades);
        userPackage.setUsers(userService.selectUserByGrades(userPackage));
        for(User user : userPackage.getUsers()){
            System.out.println("id:" + user.getId() + "  username:" + user.getUsername() + "  grade:" + user.getGrade());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("hh");
        user.setPassword("666");
        userService.insertUser(user);
    }

}