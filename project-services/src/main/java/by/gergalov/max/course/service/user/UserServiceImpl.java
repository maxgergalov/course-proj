package by.gergalov.max.course.service.user;

import by.gergalov.max.course.common.rate.UserRate;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.entity.UserRating;
import by.gergalov.max.course.repository.UserRatingRepository;
import by.gergalov.max.course.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRatingRepository userRatingRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User authenticateUser(String mail, String password) {
        User user = getByMail(mail);
        if (password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.delete(userId);
    }

    @Override
    public UserRating addUserRate(long ratedUserId, long votedUserId, UserRate rate) {
        UserRating userRating = new UserRating(ratedUserId, votedUserId, rate);
        return userRatingRepository.save(userRating);
    }

    @Override
    public int getUserLikes(long userId) {
        return userRatingRepository.getUserRateCount(userId, UserRate.LIKE);
    }

    @Override
    public int getUserDislikes(long userId) {
        return userRatingRepository.getUserRateCount(userId, UserRate.DISLIKE);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public List<UserRatingStatistic> getTopRatedUsers(int usersCount) {
        Pageable filter = new PageRequest(0, usersCount);
        List<UserRatingStatistic> statistics = new ArrayList<UserRatingStatistic>(usersCount);
        for (Object[] objects : userRatingRepository.getTopRatedUser(filter)) {
            statistics.add(new UserRatingStatistic((User) objects[0], (Long) objects[2], (Long) objects[1] - (Long) objects[2]));
        }
        return statistics;
    }

    @Override
    public CustomUserDetails getLoggedUserDetails() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public List<User> getUsers(List<Long> userIds) {
        List<User> users = new ArrayList<User>();
        users.addAll(userRepository.getUsers(userIds));
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public long getLoggedUserId() {
        return getLoggedUserDetails().getUser().getId();
    }
}
