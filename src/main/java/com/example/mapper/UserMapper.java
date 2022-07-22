package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.pojo.User;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

//    用于注册
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    @Insert("insert into tb_user values(null, #{username}, #{password})")
    void add(User user);
}
