package com.domain.dao;

import com.domain.model.User;
import com.domain.tools.CollectionsUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class UserDAOTest {

    private static UserDAO userDAO =null;

    @BeforeAll
    public static void  setUp(){

        userDAO = new UserDAO();
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
        assertEquals(userList.size(),7);
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

}