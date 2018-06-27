package com.zx.bs.controller;

import com.zx.bs.entity.Answer;
import com.zx.bs.service.AnswerService;
import com.zx.bs.service.QuestionService;
import com.zx.bs.utils.ScoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;






    @RequestMapping(value="/answerAdd", method = {RequestMethod.POST})
    @ResponseBody
    public Integer addAnswer (Answer answer){
        Integer result=answerService.insertanswer(answer);
        return result;
    }

    //通过回答id查询回答
    @RequestMapping(value="/answer/{id}", method = {RequestMethod.GET})
    //TODO ???是否返回界面
    @ResponseBody
    public Answer findAnswerById(@PathVariable("id") Integer id){
        //TODO
        return answerService.findAnswerById(id);
    }

    //通过问题id查询回答，返回该问题的所有回答的列表
    @RequestMapping(value="/answerFind/{id}", method = {RequestMethod.GET})
    //???
    @ResponseBody
    public List<Answer> findAnswerByCourseId(@PathVariable("id") Integer id){

        return answerService.findAnswerByQuestionId(id);
    }

    //通过学生id查询回答，返回该学生的所有回答的列表
    @RequestMapping(value="/answerFindByStudent/{id}", method = {RequestMethod.GET})
    //???连带问题
    @ResponseBody
    public List<Answer> findAnswerByStudentId(@PathVariable("id") Integer id){

        return answerService.findAnswerByStudentId(id);
    }

    //返回学生的各科评分
//    @RequestMapping(value="/score", method = {RequestMethod.POST})
//    @ResponseBody
//    public Map<String,Integer> scoreByStudentId(@RequestParam("student_id") int id){
//        List<Answer> answerList=answerService.findAnswerByStudentId(id);
//        HashMap<String,Integer> courseHashMap=new HashMap<>();
//
//        for(Answer answer:answerList){
//            String c_name=answer.getCourse_name();//课程名称
//          if(courseHashMap.containsKey(c_name)){
//              //课程所有问题的回答
//              int c_num=courseHashMap.get(c_name);
//              courseHashMap.put(c_name,c_num+1);//该课程的回答加一
//          }else {
//              courseHashMap.put(c_name,1);
//          }
//        }
//        for(String key:courseHashMap.keySet()){
//            int score=ScoreUtils.score(courseHashMap.get(key));//计算分数
//            courseHashMap.put(key,score);
//        }
//        return courseHashMap;
//    }

    //通过学生id和问题id 返回该同学该问题的回答
//    @RequestMapping(value="/scoreFind", method = {RequestMethod.POST})
//    @ResponseBody
//    public List<Answer> scoreByStudentIdAndCourse(@RequestParam("student_id") int s_id,@RequestParam("question_id") int q_id){
//        return answerService.findAnswerByStudentAndQuestionId(s_id,q_id);
//    }
}
