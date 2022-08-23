package com.example.user;

import com.example.SpringFwExApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class UserServiceImplTest {
//    AppConfig appConfig = new AppConfig();
//    UserService userService = appConfig.userService();
//    @Autowired
//    UserService userService;

    ApplicationContext ac = new AnnotationConfigApplicationContext(SpringFwExApplication.class);
    UserService userService = ac.getBean(UserService.class);

    @Test
    public void signupTest() {
        User user = new User(0L, "hipo", UserGrade.GRADE_2);
        userService. signup(user);

        User findUser = userService.findUser(0L);
        Assertions.assertThat(findUser.getName()).isEqualTo(user.getName());
    }
}
