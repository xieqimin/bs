package com.zx.bs.dao;

import com.zx.bs.Dao.AnswerDao;
import com.zx.bs.entity.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerDaoTest {
    @Autowired
    private AnswerDao answerDao;

    @Test
    public void findAnswerById() {
        Answer answer=new Answer();
        answer.setAnswer_id(1);
        answer.setQuestion_id(1);
        answer.setUser_id(12);
        answer.setAnswer_content("gdf");
        System.out.println(answerDao.updateAnswer(answer));
    }

    @Test
    public void insertAnswer() {
        Answer answer=new Answer();
        answer.setQuestion_id(1);
        answer.setUser_id(12);
        answer.setAnswer_content("djfgdf");
        System.out.println(answerDao.insertAnswer(answer));
    }
}