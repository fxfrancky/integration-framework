package com.domain.dao;

import com.domain.model.User;
import com.domain.tools.CollectionsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
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


        assertEquals(userList.size(),6);
    }

    @Test
    void testFindUserById() throws Exception {

        Integer idUser = 101;
        User usr = userDAO.getUserByIdUser(idUser);
        if (usr!=null){
            log.info(" **************** My USER is not empty **************  :  " + usr.getLogin());
        }
        assertNotNull(usr);
        assertEquals(101,usr.getIdUser());
        assertEquals("ritamkn",usr.getLogin());

    }

}