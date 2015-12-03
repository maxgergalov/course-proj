package by.gergalov.max.course.controllers.shop;

import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.service.comment.CommentService;
import by.gergalov.max.course.service.offer.OfferRatingStatistic;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserRatingStatistic;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopControllerLogic {

    @Autowired
    OfferService offerService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    private final String defaultImageUrl = "http://placehold.it/320x150";

    public List<OfferDescription> getOfferDescriptions(int size) {
        List<OfferDescription> offerDescriptions = new ArrayList<OfferDescription>(size);
        for (OfferRatingStatistic offerStatistic : offerService.getLastOffers(size)) {
            Offer offer = offerStatistic.getOffer();
            String url = offer.getImages().isEmpty() ? defaultImageUrl : offer.getImages().get(0).getUrl();
            Double rating = offerStatistic.getRating();
            rating = rating == null ? 0 : rating;
            offerDescriptions.add(new OfferDescription(offer, offer.getComments().size(), url, rating));
        }
        return offerDescriptions;
    }

    public List<UserRatingStatistic> getTopUsers(int count) {
        return userService.getTopRatedUsers(count);
    }

    public List<OfferRatingStatistic> getTopOffers(int count) {
        return offerService.getTopRatedOffers(count);
    }

}
