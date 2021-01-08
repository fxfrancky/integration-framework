package com.domain.dao;

import com.domain.model.User;
import com.domain.mybatis.factory.MyBatisSqlSessionFactory;
import com.domain.mybatis.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
public class UserDAO {

   private static final SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.produceFactory();

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

    /**
     * Delete User By Login
     * @param login
     */
    public void  deleteUserByLogin(String login)throws Exception {
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUserByLogin(login);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception ex){
            log.info("UserDAO Exception  deleteUserByLogin" + ex.getMessage());
            throw new Exception("UserDAO Exception  deleteUserByLogin" + ex.getMessage());
        }
    }

    /**
     * Delete All Users
     * @param logins
     */
    public void  deleteAllUsers(List<String> logins)throws Exception {
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteAllUsers(logins);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception ex){
            log.info("UserDAO Exception  deleteAllUsers" + ex.getMessage());
            throw new Exception("UserDAO Exception  deleteAllUsers" + ex.getMessage());
        }

    }

    /**
     * Update User
     * @param usr
     */
    public void  updateUser(User usr)throws Exception {
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(usr);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception ex){
            log.info("UserDAO Exception  updateUser" + ex.getMessage());
            throw new Exception("UserDAO Exception  updateUser" + ex.getMessage());
        }
    }

    public void initData() throws Exception {

      //deleteAllUsers(logins String[]);
      try {
        User usr1 = new User();
        usr1.setLogin("fxfrancky");
        usr1.setPassword("fxfrancky100");
        usr1.setEmail("francky@yahoo.com");
        createNewUser(usr1);

        User usr2 = new User();
        usr2.setLogin("ritamkn");
        usr2.setPassword("ritamkn101");
        usr2.setEmail("ritamkn@yahoo.com");
        createNewUser(usr2);


        User usr3 = new User();
        usr3.setLogin("evamkn");
        usr3.setPassword("evamkn102");
        usr3.setEmail("evamkn102@yahoo.com");
        createNewUser(usr3);

        User usr4 = new User();
        usr4.setLogin("stevemkn");
        usr4.setPassword("stevemkn103");
        usr4.setEmail("stevemkn@yahoo.com");
        createNewUser(usr4);


        User usr5 = new User();
        usr5.setLogin("julesbene");
        usr5.setPassword("julesbene104");
        usr5.setEmail("julesbene@yahoo.com");
        createNewUser(usr5);

          User usr6 = new User();
          usr6.setLogin("jordanowona");
          usr6.setPassword("jordanowona104");
          usr6.setEmail("jordanowona@yahoo.com");
          createNewUser(usr6);


      }catch (Exception ex){
          log.info("UserDAO Exception  initData" + ex.getMessage());
          throw new Exception("UserDAO Exception  initData" + ex.getMessage());
      }

    }


    /**
     * Insert All Users
     */
    public void  insertAllUsers()throws Exception {

        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertAllUsers(getInitUsersList());
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception ex){
            log.info("UserDAO Exception  insertAllUsers" + ex.getMessage());
            throw new Exception("UserDAO Exception  insertAllUsers" + ex.getMessage());
        }

    }

    /**
     * Init User List
     * @return
     */
    public List<User> getInitUsersList(){

        List<User> userList = new ArrayList<User>();
        User usr1 = new User();
        usr1.setLogin("fxfrancky");
        usr1.setPassword("fxfrancky100");
        usr1.setEmail("francky@yahoo.com");
        userList.add(usr1);

        User usr2 = new User();
        usr2.setLogin("ritamkn");
        usr2.setPassword("ritamkn101");
        usr2.setEmail("ritamkn@yahoo.com");
        userList.add(usr2);

        User usr3 = new User();
        usr3.setLogin("evamkn");
        usr3.setPassword("evamkn102");
        usr3.setEmail("evamkn102@yahoo.com");
        userList.add(usr3);

        User usr4 = new User();
        usr4.setLogin("stevemkn");
        usr4.setPassword("stevemkn103");
        usr4.setEmail("stevemkn@yahoo.com");
        userList.add(usr4);

        User usr5 = new User();
        usr5.setLogin("julesbene");
        usr5.setPassword("julesbene104");
        usr5.setEmail("julesbene@yahoo.com");
        userList.add(usr5);

        User usr6 = new User();
        usr6.setLogin("jordanowona");
        usr6.setPassword("jordanowona104");
        usr6.setEmail("jordanowona@yahoo.com");
        userList.add(usr6);
        return userList;
    }

}
