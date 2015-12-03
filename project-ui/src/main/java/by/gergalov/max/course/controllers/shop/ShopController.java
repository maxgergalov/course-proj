package by.gergalov.max.course.controllers.shop;

import by.gergalov.max.course.service.comment.CommentService;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

    @Autowired
    OfferService offerService;

    @Autowired
    CommentService commentService;

    @Autowired
    ShopControllerLogic logic;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView getShopPage() {
        ModelAndView model = new ModelAndView("shop");
        model.addObject("lastOffers", logic.getOfferDescriptions(1));
        model.addObject("topUsers", logic.getTopUsers(5));
        model.addObject("topOffers", logic.getTopOffers(5));

        return model;
    }

/*    @RequestMapping(value = "/shop/json", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HashMap get() {
        HashMap<String,Object> rez = new HashMap<String, Object>();
        rez.put("lastOffers", logic.getOfferDescriptions(3));

        return rez;
    }*/
}
