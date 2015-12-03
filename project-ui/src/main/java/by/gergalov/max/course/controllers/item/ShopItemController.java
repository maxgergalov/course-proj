package by.gergalov.max.course.controllers.item;

import by.gergalov.max.course.common.rate.OfferRate;
import by.gergalov.max.course.controllers.comment.CommentForm;
import by.gergalov.max.course.entity.Comment;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.OfferRating;
import by.gergalov.max.course.entity.OfferRequest;
import by.gergalov.max.course.repository.CommentRepository;
import by.gergalov.max.course.service.comment.CommentService;
import by.gergalov.max.course.service.load.CommentDataLoader;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShopItemController {

    @Autowired
    OfferService offerService;

    @Autowired
    CommentService commentService;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentDataLoader commentDataLoader;

    @Autowired
    UserService userService;
    @Autowired
    ShopItemLogic logic;


    @RequestMapping(value = "/item/{offerId}", method = RequestMethod.GET)
    public ModelAndView getItemPage(@PathVariable("offerId") Long id) {
        Offer offer = offerService.getById(id);
        ModelAndView model = new ModelAndView("item");
        if (offer != null) {
            model.addObject("offerDescription", logic.getOfferDescription(offer));
            return model;
        }
        return new ModelAndView("shop");
    }

    @RequestMapping(value = "/item/addofferrate", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole(T(by.gergalov.max.course.common.roles.UserRole).ROLE_USER.toString())")
    public double addOfferRating(@RequestBody AddRatingRequest request) {
        long userId = userService.getLoggedUserDetails().getUser().getId();
        OfferRating rating = offerService.getUserOfferRate(request.getOfferId(), userId);
        if (rating == null) {
            offerService.addOfferRate(request.getOfferId(), userId, OfferRate.getOfferRateByScore(request.getScore()));
            return offerService.getOfferRateMean(request.getOfferId());
        }
        return -1;
    }

    @RequestMapping(value = "/item/comment", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Comment comment(@RequestBody CommentForm commentForm) {
        Comment comment = commentDataLoader.getOne();
        comment.setDescription(commentForm.getDescription());
        return comment;
    }

    @RequestMapping(value = "/offer/{offerId}/deal", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole(T(by.gergalov.max.course.common.roles.UserRole).ROLE_USER.toString())")
    public double makeDeal(@PathVariable("offerId")Long offerId) {
        Long userId = userService.getLoggedUserId();
        OfferRequest offerRequest = new OfferRequest();
        try {
            offerRequest = offerService.addOfferRequest(offerId, userId);
            return 34535;
        } catch (Exception e){
        }
        System.out.println(offerRequest);
        return 9797;
    }
}
