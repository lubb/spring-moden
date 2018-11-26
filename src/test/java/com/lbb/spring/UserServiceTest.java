package com.lbb.spring;

import com.lbb.spring.model.User;
import com.lbb.spring.parse.ClassPathXmlApplicationContext;
import com.lbb.spring.service.UserService;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void saveTest() throws Exception{
        ClassPathXmlApplicationContext benas = new ClassPathXmlApplicationContext();
        UserService userService = (UserService) benas.getBean("userService");
        User user = new User();
        user.setName("lbb");
        userService.addUser(user);
    }
}
