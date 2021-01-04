package com.domain.dao;

import com.domain.model.User;
import com.domain.mybatis.factory.MyBatisSqlSessionFactory;
import com.domain.mybatis.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;



@Slf4j
public class UserDAO {

   private static final SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.produceFactory();
   //private static SqlSession sqlSession = MyBatisSqlSessionFactory.produceFactory().openSession();
   //private static final UserMapper userMapper= sqlSession.getMapper(UserMapper.class);

    public List<User> findAllUsers() throws Exception {
        List<User> users = null;
       try{
           SqlSession sqlSession = sqlSessionFactory.openSession();
           UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            users = userMapper.selectUsers();
       }catch (Exception e){
            log.info("UserDAO Exception  findAllUsers" + e.getMessage());
            throw new Exception("UserDAO Exception  findAllUsers" + e.getMessage());
      }
        return users;
    }

    public User getUserByLogin(String login) throws Exception {
        User usr = null;
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            usr = userMapper.getUserByLogin(login);
        }catch (Exception e){
            log.info("UserDAO Exception  getUserByLogin" + e.getMessage());
            throw new Exception("UserDAO Exception  findAllUsers" + e.getMessage());
        }
        return usr;
    }

    public void createNewUser(User usr) throws Exception {
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertNewUser(usr.getLogin(),usr.getPassword(),usr.getEmail());
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            log.info("UserDAO Exception  createNewUser" + e.getMessage());
            throw new Exception("UserDAO Exception  createNewUser" + e.getMessage());
        }
    }
}
