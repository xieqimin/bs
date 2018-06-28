package com.zx.bs.service;


import com.zx.bs.Dao.UserDao;
import com.zx.bs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao studentDao;

    public Integer findStudentByIdAndPasswd(int id, String pwd) {
        User user = studentDao.findUserById(id);
        if (user != null)
            if (user.getUser_passwd().equals(pwd))
                return 1;
            else
                return -1;//密码错误
        else return -2;//没有此id
    }
    @Transactional
    public Integer insertStudent(User student){
        Integer integer=studentDao.InsertUser(student);
        return integer;
    }

    public Integer deleteStudentById(int id){
        Integer integer=studentDao.DeleteUserById(id);
        return integer;
    }
    public User findStudentById(int id){
        User student=studentDao.findUserById(id);
        return student;
    }
}
