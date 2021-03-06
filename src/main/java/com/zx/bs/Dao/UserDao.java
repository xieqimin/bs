package com.zx.bs.Dao;

import com.zx.bs.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    @Select("select * from user where user_id=#{id}")
    User findStudentById(@Param("id") Integer id);

    @Select("select * from user where user_id=#{id},user_passwd=#{pwd}")
    User findUserByIdAndPasswd(@Param("id") Integer id, @Param("pwd") String pwd);

    @Insert("INSERT  INTO user  VALUES(#{user_id},#{user_name},#{user_passwd});")
    Integer InsertUser(User user);

    @Delete("delete from user where user_id =#{id}")
    Integer DeleteUserById(@Param("id") Integer id);
}
