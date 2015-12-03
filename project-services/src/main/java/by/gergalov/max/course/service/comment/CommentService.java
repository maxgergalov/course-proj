package by.gergalov.max.course.service.comment;

import by.gergalov.max.course.entity.Comment;
import by.gergalov.max.course.service.common.BaseService;

import java.util.List;


public interface CommentService extends BaseService<Comment> {

    Comment saveComment(Comment comment);

    void removeComment(long commendId);

    List<Comment> getByOfferId(long offerId);

    List<Comment> getByUserId(long userId);

    int getOffersCommentCount(long offerId);

}
