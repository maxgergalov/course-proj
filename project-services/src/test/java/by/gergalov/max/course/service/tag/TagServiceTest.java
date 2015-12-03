package by.gergalov.max.course.service.tag;

import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.load.OfferDataLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class TagServiceTest {
    @Autowired
    OfferDataLoader offersDataLoader;
    @Autowired
    OfferService offerService;
    @Autowired
    TagService tagService;


    @Test
    public void fakeTest() {

    }
}
