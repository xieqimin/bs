package com.zx.bs.Dao;

import com.zx.bs.entity.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface QuestionDao {
    @Select("select * from question where question_id=#{id}")
    Question findQuestionById(@Param("id") Integer id);

    @Insert("insert into question (question_id,user_id,question_conent) values(#{question_id},#{user_id},#{question_conent});")
    Integer insertQuestion(Question question);

    @Select("select * from question where user_id=#{id}")
    List<Question> findQuestionByUserId(@Param("id") Integer id);

    @Select("select * from question ")
    List<Question> findQuestion();

    @Update("update question set question_conent=#{question_conent} where question_id=#{question_id}")
    Integer updateQuestion(Question question);
}
