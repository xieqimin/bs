package com.zx.bs.controller;

import com.zx.bs.entity.User;
import com.zx.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method = {RequestMethod.POST})
    @ResponseBody
    public String login(User student, HttpSession session){
        int id=student.getUser_id();
        String pwd=student.getUser_passwd();
        Integer result= userService.findStudentByIdAndPasswd(id,pwd);
        session.setAttribute("user_id",id);
        return ""+result;
    }
    //TODO
    //
    @RequestMapping(value="/registered", method = {RequestMethod.POST})
    @ResponseBody
    public Integer addTeacher(User student){
        Integer result= userService.insertStudent(student);
        return result;
    }

    //推出登陆
    @RequestMapping(value="/out")
    public String StudentOut(HttpSession session){
        session.removeAttribute("user_id");
        //TODO
        return "redirect:/login.html";
    }
}
