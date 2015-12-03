package by.gergalov.max.course.service.user;

import by.gergalov.max.course.common.rate.UserRate;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.entity.UserRating;
import by.gergalov.max.course.service.common.BaseService;

import java.util.List;


public interface UserService extends BaseService<User>{

    User registerUser(User user);

    User updateUser(User user);

    void deleteUser(long userId);

    User getByMail(String mail);

    User authenticateUser(String mail,String password);

    UserRating addUserRate(long ratedUserId, long votedUserId, UserRate rate);

    int getUserLikes(long userId);

    int getUserDislikes(long userId);

    List<UserRatingStatistic> getTopRatedUsers(int usersCount);

     CustomUserDetails getLoggedUserDetails();

    List<User> getUsers(List<Long> userIds);

    List<User> getAllUsers();

    long getLoggedUserId();

}
