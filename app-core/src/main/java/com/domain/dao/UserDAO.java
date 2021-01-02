package com.domain.dao;

import com.domain.model.User;
import com.domain.mybatis.factory.MyBatisSqlSessionFactory;
import com.domain.mybatis.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
@Slf4j
public class UserDAO  implements Serializable {

   //private static final SqlSession sqlSession = MyBatisSqlSessionFactory.produceFactory().openSession();
    private static final UserMapper userMapper= MyBatisSqlSessionFactory.produceFactory().openSession().getMapper(UserMapper.class);

    public List<User> findAllUsers() throws Exception {
        List<User> users = null;
        try{
           // UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            users = userMapper.selectUsers();
        }catch (Exception e){
            log.info("UserDAO Exception  findAllUsers" + e.getMessage());
        }
        return users;
    }

    public User getUserByIdUser(Integer idUser) throws Exception {
        User usr = null;
        try{
           // UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            usr = userMapper.getUserByIdUser(idUser);
        }catch (Exception e){
            log.info("UserDAO Exception  grtUserByIdUser" + e.getMessage());
        }
        return usr;
    }
}
