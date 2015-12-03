package by.gergalov.max.course.service.user;

import by.gergalov.max.course.entity.User;


public class UserRatingStatistic {

    private User user;

    private Long likes;

    private Long dislikes;

    public User getUser() {
        return user;
    }

    public UserRatingStatistic(User user, Long likes, Long dislikes) {
        this.user = user;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Long getLikes() {
        return likes;
    }

    public Long getDislikes() {
        return dislikes;
    }
}
