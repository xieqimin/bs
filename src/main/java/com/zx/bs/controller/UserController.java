package com.zx.bs.controller;

import com.zx.bs.model.User;
import com.zx.bs.service.QuestionService;
import com.zx.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

//TODO 登陆id addquestiontianjiauserid
//TODO html模板更改
//TODO 路径

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value="/login", method = {RequestMethod.POST})

    public ModelAndView login(User user, HttpSession session, Map<String,Object> map){
        int id=user.getUser_id();
        String pwd=user.getUser_passwd();
        //System.out.println(id);
        //System.out.println(pwd);
        Integer result= userService.findStudentByIdAndPasswd(id,pwd);
        if(result==1) {
            session.setAttribute("user_id", id);
            //return "redirect:/";
            User user1=userService.findStudentById(id);
            session.setAttribute("user_name",user1.getUser_name());
            map.put("user_name",user1.getUser_name());
            map.put("question",questionService.findQuestion());
            map.put("login",true);
            return new ModelAndView("index");
        }else {
            if (result==-1) {//pwd
                map.put("error","密码错误");
                return new ModelAndView("error",map);
            }
            else {//id
                map.put("error","没有此账户");
                return new ModelAndView("error",map);
            }
        }
    }
    //TODO
    //
    @RequestMapping(value="/registered", method = {RequestMethod.POST})
    @ResponseBody
    public Integer addTeacher(User user){
        Integer result= userService.insertStudent(user);
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
