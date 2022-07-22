package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }
    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = mapper.selectByUsername(user.getUsername());
        if(u == null){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;

    }
}
