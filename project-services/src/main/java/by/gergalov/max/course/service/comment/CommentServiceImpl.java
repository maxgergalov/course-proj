package by.gergalov.max.course.service.comment;

import by.gergalov.max.course.entity.Comment;
import by.gergalov.max.course.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public long count() {
        return commentRepository.count();
    }

    @Override
    public Comment getById(long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void removeComment(long commendId) {
        commentRepository.delete(commendId);
        commentRepository.flush();
    }

    @Override
    public List<Comment> getByOfferId(long offerId) {
        return commentRepository.findByOfferId(offerId);
    }

    @Override
    public List<Comment> getByUserId(long userId) {
        return commentRepository.findByUserId(userId);
    }

    @Override
    public int getOffersCommentCount(long offerId) {
        return commentRepository.getOffersCommentCount(offerId);
    }


}
