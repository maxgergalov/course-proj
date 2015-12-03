package by.gergalov.max.course.service.generation;

import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.load.CommentDataLoader;
import by.gergalov.max.course.service.load.OfferDataLoader;
import by.gergalov.max.course.service.load.UserDataLoader;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenerationServiseImpl implements GenerationService {

    @Autowired
    UserService userService;
    @Autowired
    UserDataLoader userDataLoader;
    @Autowired
    OfferDataLoader offerDataLoader;
    @Autowired
    CommentDataLoader commentDataLoader;

    Random random = new Random();
    List<User> users;
    List<Offer> offers = new ArrayList<Offer>(20);

    @Override
    public void generate() {
        users = userDataLoader.getUsers(12);
        for (User user : users) {
            offers.addAll(offerDataLoader.getOffers(random.nextInt(5), user.getId()));
            userDataLoader.addRatingToUser(users, user.getId(), random.nextInt(6), random.nextInt(6));
        }
        for (Offer offer : offers) {
            int n = random.nextInt(4);
            offerDataLoader.addRatingToOffer(users, offerDataLoader.getRandomRatings(n), offer.getId());
            commentDataLoader.addCommentsToOffer(users, offer.getId(), random.nextInt(5));
        }
    }

}
