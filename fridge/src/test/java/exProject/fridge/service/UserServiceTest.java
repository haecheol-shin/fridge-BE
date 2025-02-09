package exProject.fridge.service;

import exProject.fridge.model.User;
import exProject.fridge.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    
    @Test
    public void 회원가입() throws Exception {
        // given
        User user = new User();
        user.setId(1);
        user.setUsername("Shin");
        user.setPassword("qwer");

        // when
        boolean signup = userService.signup(user);

        // then
        assertTrue(signup);
    }
}
