package com.zx.bs.dao;

import com.zx.bs.Dao.UserDao;
import com.zx.bs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void findStudentById() {
        User user=userDao.findUserById(12);
        System.out.println(user.getUser_name());
    }

    @Test
    public void findUserByIdAndPasswd() {
    }

    @Test
    public void insertUser() {
        User user=new User();
        user.setUser_id(123);
        user.setUser_name("hdffg");
        userDao.InsertUser(user);
    }
}