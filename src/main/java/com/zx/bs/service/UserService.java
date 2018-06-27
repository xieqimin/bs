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

    public Integer findStudentByIdAndPasswd(int id, String pwd){
        User student=studentDao.findUserByIdAndPasswd(id,pwd);
        if(student!=null)
        return 1;
        else return -1;
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
        User student=studentDao.findStudentById(id);
        return student;
    }
}
