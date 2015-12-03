package by.gergalov.max.course.service.load;

import by.gergalov.max.course.common.rate.UserRate;
import by.gergalov.max.course.common.roles.UserRole;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDataLoader {

    @Autowired
    private UserService userService;
    private User defaultUser = null;

    public User getOne() {
        if (defaultUser == null) {
            defaultUser = userService.registerUser(new User("name", "email@gmail.com", "password", UserRole.ROLE_USER));
        }
        return defaultUser;
    }

    public void cleanOne() {
        userService.deleteUser(getOne().getId());
        defaultUser = null;
    }

    public List<User> getUsers(int count) {
        List<User> users = new ArrayList<User>(5);
        for (int i = 0; i < count; i++) {
            String email = "email" + i +"@gmail.com";
            String name = "name" + i;
            users.add(userService.registerUser(new User(name, email, "test", UserRole.ROLE_USER)));
        }
        return users;
    }

    public void addRatingToUser(List<User> users, Long userId, int likes, int dislikes) {
        for (int j = 0; j < users.size() && j < likes; j++) {
            userService.addUserRate(userId, users.get(j).getId(), UserRate.LIKE);
        }
        for (int j = likes; j < users.size() && j < likes + dislikes; j++) {
            userService.addUserRate(userId, users.get(j).getId(), UserRate.DISLIKE);
        }
    }

}
