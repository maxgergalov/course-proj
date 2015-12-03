package by.gergalov.max.course.service.user;

import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.load.UserDataLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDataLoader dataLoader;

    @Test
    public void createAndDeleteUserTest() {
        dataLoader.getOne();
        User user = userService.getByMail("email@gmail.com");
        assertEquals(1, userService.count());
        assertEquals("password", user.getPassword());
        assertEquals("name", user.getName());
        dataLoader.cleanOne();
        assertEquals(0, userService.count());
    }

    @Test
    public void getTopUsersTest() {
        List<User> users = dataLoader.getUsers(10);
        dataLoader.addRatingToUser(users, users.get(0).getId(), 7, 2);
        dataLoader.addRatingToUser(users, users.get(7).getId(), 5, 0);
        dataLoader.addRatingToUser(users, users.get(2).getId(), 6, 3);
        dataLoader.addRatingToUser(users, users.get(4).getId(), 4, 3);

        List<UserRatingStatistic> ratedUsers = userService.getTopRatedUsers(5);

        assertEquals(users.get(0).getId(),ratedUsers.get(0).getUser().getId());
        assertEquals(users.get(7).getId(),ratedUsers.get(1).getUser().getId());
        assertEquals(users.get(2).getId(),ratedUsers.get(2).getUser().getId());
        assertEquals(users.get(4).getId(),ratedUsers.get(3).getUser().getId());

        for(User user : users){
            userService.deleteUser(user.getId());
        }

    }


}
