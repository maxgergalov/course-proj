package by.gergalov.max.course.service.load;

import by.gergalov.max.course.common.roles.UserRole;
import by.gergalov.max.course.entity.Comment;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.comment.CommentService;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class CommentDataLoader {

    @Autowired
    private UserService userService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private CommentService commentService;
    private Comment defaultComment = null;
    private final String description = "Далеко-далеко за словесными горами в стране гласных и согласных" +
            " живут рыбные тексты. Вдали от всех живут они в буквенных домах на берегу Семантика большого языкового океана.";

    public Comment getOne() {
        if (defaultComment == null) {
            User user = userService.registerUser(new User("offer", "offer@gmail.com", "offer", UserRole.ROLE_USER));
            Offer offer = offerService.registerOffer(new Offer("title", new BigDecimal(4.32), "description", user.getId()));
            defaultComment = commentService.saveComment(new Comment(offer.getId(), user.getId(), "description"));
        }
        return defaultComment;
    }

    public void cleanOne() {
        userService.deleteUser(offerService.getById(getOne().getOfferId()).getUserId());
        defaultComment = null;
    }

    public List<Comment> addCommentsToOffer(List<User> users, Long offerId, int count) {
        List<Comment> comments = new ArrayList<Comment>(count);
        for (int i = 0; i < count && i < users.size(); i++) {
            comments.add(commentService.saveComment(new Comment(offerId, users.get(i).getId(), description)));
        }
        return comments;
    }
}
