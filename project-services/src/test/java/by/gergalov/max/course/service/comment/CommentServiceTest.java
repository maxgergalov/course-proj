package by.gergalov.max.course.service.comment;

import by.gergalov.max.course.entity.Comment;
import by.gergalov.max.course.service.load.CommentDataLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class CommentServiceTest {

    @Autowired
    CommentDataLoader commentDataLoader;
    @Autowired
    CommentService commentService;

    @Test
    public void createAndDeleteCommentTest() {
        Long offerId = commentDataLoader.getOne().getId();
        Comment comment = commentService.getById(offerId);
        assertEquals(1, commentService.count());
        assertEquals("description", comment.getDescription());
        assertEquals(1,commentService.getByUserId(1).size());//TODO write OWN test
        commentDataLoader.cleanOne();
        assertEquals(0, commentService.count());
    }
}
