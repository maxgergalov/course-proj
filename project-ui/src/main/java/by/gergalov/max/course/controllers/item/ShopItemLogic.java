package by.gergalov.max.course.controllers.item;

import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.service.comment.CommentService;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopItemLogic {

    @Autowired
    OfferService offerService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    private final String defaultImageUrl = "http://placehold.it/800x300";

    public ItemDescription getOfferDescription(Offer offer) {
        ItemDescription description = new ItemDescription();
        description.setOffer(offer);
        Double rating = offerService.getOfferRateMean(offer.getId());
        description.setRating(rating == null ? 0 : rating);
        description.setComments(offer.getComments());
        String url = offer.getImages().isEmpty() ? defaultImageUrl : offer.getImages().get(0).getUrl();
        url = url == null ? defaultImageUrl : url;
        description.setImageUrl(url);
        return description;
    }
}
