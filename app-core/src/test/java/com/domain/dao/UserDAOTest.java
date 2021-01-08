package com.domain.dao;

import com.domain.model.User;
import com.domain.tools.CollectionsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class UserDAOTest {

    private static UserDAO userDAO =null;

    @BeforeAll
    public static void  setUp() throws Exception {
        userDAO = new UserDAO();
        initData();
    }

   @Test
    void testFindAllUsers() throws Exception {

        List<User> userList = userDAO.findAllUsers();
        if (!CollectionsUtils.isNullOrEmptyCollection(userList)){
            userList.forEach(user -> {
                log.info(" ************* " + "User ID : " + user.getIdUser() + " User LOGIN : " + user.getLogin() + " User EMAIL : " + user.getEmail() + " User PASSWORD : " + user.getPassword() + " ************");
                System.out.println("User ID : " + user.getIdUser() + " User LOGIN : " + user.getLogin() + " User EMAIL : " + user.getEmail() + " User PASSWORD : " + user.getPassword());
            });
        }
        assertNotNull(userList);
        assertEquals(userList.size(),6);
    }

    @Test
    void testFindUserByLogin() throws Exception {

        String login  = "ritamkn";
        User usr = userDAO.getUserByLogin(login);
        if (usr!=null){
            log.info(" **************** My USER is not empty **************  :  " + usr.getLogin());
        }
        assertNotNull(usr);
        assertEquals("ritamkn@yahoo.com",usr.getEmail());
        assertEquals("ritamkn",usr.getLogin());
        assertEquals("ritamkn101",usr.getPassword());

    }

    @Test
    void testCreateUser() throws Exception {
        User usr = new User();
        usr.setLogin("andreaowona");
        usr.setPassword("andreaowona102");
        usr.setEmail("andreaowona@yahoo.com");
        userDAO.createNewUser(usr);
        User user2 = userDAO.getUserByLogin("andreaowona");

        assertNotNull(user2);
        assertEquals("andreaowona",user2.getLogin());
        assertEquals("andreaowona102",user2.getPassword());
        assertEquals("andreaowona@yahoo.com",user2.getEmail());

    }

    @Test
    public void  testDeleteUserByLogin()throws Exception{
        String login = "fxfrancky";
        User usr = userDAO.getUserByLogin(login);
        assertNotNull(usr);

        userDAO.deleteUserByLogin(login);
        User usrDeleted = userDAO.getUserByLogin(login);
        assertNull(usrDeleted);

    }

    @Test
    void testUpdateUser()throws Exception{

        String login = "fxfrancky";
        User usr = userDAO.getUserByLogin(login);
        assertNotNull(usr);
        assertEquals("fxfrancky100",usr.getPassword());
        assertEquals("francky@yahoo.com",usr.getEmail());
        usr.setPassword("fxfrancky999");
        usr.setEmail("francky999@yahoo.com");
        userDAO.updateUser(usr);
        User usr2 = userDAO.getUserByLogin(login);
        assertNotNull(usr2);
        assertEquals("fxfrancky999",usr.getPassword());
        assertEquals("francky999@yahoo.com",usr.getEmail());

    }

    public static void initData() throws Exception {
        List<String> logins =  new ArrayList<String>();
        logins.add("fxfrancky");
        logins.add("ritamkn");
        logins.add("evamkn");
        logins.add("stevemkn");
        logins.add("julesbene");
        logins.add("jordanowona");
        logins.add("andreaowona");

        userDAO.deleteAllUsers(logins);
        userDAO.insertAllUsers();
    }


}