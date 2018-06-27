package com.zx.bs.dao;

import com.zx.bs.Dao.QuestionDao;
import com.zx.bs.entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionDaoTest {
    @Autowired
    private QuestionDao questionDao;
    @Test
    public void findQuestion() {

       List list= questionDao.findQuestion();
       System.out.println(list.get(0));
    }
    @Test
    public void findQuestionById() {
        Question question=new Question();
        question.setUser_id(12);
        question.setQuestion_conent("hdf");
        question.setQuestion_id(1);
        System.out.println(questionDao.updateQuestion(question));
    }

    @Test
    public void insertQuestion() {
        Question question=new Question();
        question.setUser_id(12);
        question.setQuestion_conent("hdfgdf");
        int result=questionDao.insertQuestion(question);
        System.out.println(result);
    }
}