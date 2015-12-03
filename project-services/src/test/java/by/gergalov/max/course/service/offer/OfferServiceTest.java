package by.gergalov.max.course.service.offer;

import by.gergalov.max.course.common.rate.OfferRate;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.load.OfferDataLoader;
import by.gergalov.max.course.service.user.UserService;
import by.gergalov.max.course.service.load.UserDataLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class OfferServiceTest {


    @Autowired
    private OfferService offerService;
    @Autowired
    private UserService userService;
    @Autowired
    private OfferDataLoader offersDataLoader;
    @Autowired
    private UserDataLoader usersDataLoader;

    @Test
    public void createAndDeleteOfferTest() {
        Long offerId = offersDataLoader.getOne().getId();
        Offer offer = offerService.getById(offerId);
        assertEquals(1, offerService.count());
        assertEquals("description", offer.getDescription());
        assertEquals("title", offer.getTitle());
        assertEquals(new BigDecimal(4.32).setScale(2, RoundingMode.DOWN), offer.getPrice());
        offersDataLoader.cleanOne();
        assertEquals(0, offerService.count());
    }


    @Test
    public void getTopOffersTest() {
        List<Offer> offers = offersDataLoader.getOffers(6, usersDataLoader.getOne().getId());
        List<User> users = usersDataLoader.getUsers(6);
        List<OfferRate> rates = Arrays.asList(OfferRate.TWO, OfferRate.FIVE, OfferRate.ONE, OfferRate.TWO, OfferRate.FOUR);
        offersDataLoader.addRatingToOffer(users, rates, offers.get(0).getId());
        rates = Arrays.asList(OfferRate.FIVE, OfferRate.FIVE, OfferRate.FIVE, OfferRate.THREE, OfferRate.FOUR);
        offersDataLoader.addRatingToOffer(users, rates, offers.get(2).getId());
        rates = Arrays.asList(OfferRate.TWO, OfferRate.TWO, OfferRate.THREE);
        offersDataLoader.addRatingToOffer(users, rates, offers.get(5).getId());
        List<OfferRatingStatistic> ratedOffers = offerService.getTopRatedOffers(3);

        assertEquals(offers.get(2).getId(), ratedOffers.get(0).getOffer().getId());
        assertEquals(offers.get(0).getId(), ratedOffers.get(1).getOffer().getId());
        assertEquals(offers.get(5).getId(), ratedOffers.get(2).getOffer().getId());

        usersDataLoader.cleanOne();
        for(User user : users){
            userService.deleteUser(user.getId());
        }
    }

}
