package by.gergalov.max.course.controllers.user;

import by.gergalov.max.course.controllers.shop.ShopControllerLogic;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserControllerLogic userControllerLogiclogic;
    @Autowired
    UserService userService;
    @Autowired
    OfferService offerService;
    @Autowired
    ShopControllerLogic logic;

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public ModelAndView getOffersPage() {
        ModelAndView model = new ModelAndView("/user/offers");
        User user = userService.getLoggedUserDetails().getUser();
        model.addObject("userOffers", user.getOffers());
        model.addObject("userRequests", user.getRequests());
        model.addObject("howOffers",offerService.count());
        model.addObject("howUsers",userService.count());
        return model;
    }
    /*@RequestMapping(value = "/createOffer", method = RequestMethod.GET)
    public String createOfferPage(Model model) {
        model.addAttribute("CreateOfferForm", new CreateOfferForm());
        return "/createOffer";
    }*/

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public ModelAndView getRequestsPage() {
        ModelAndView model = new ModelAndView("/user/requests");
        User user = userService.getLoggedUserDetails().getUser();
        model.addObject("userOffers", user.getOffers());
        model.addObject("userRequests", user.getRequests());
        return model;
    }

    @RequestMapping(value = "/offers/delete", method = RequestMethod.POST )
    public String deleteOffer(@RequestParam("id") Long offerId) {
        offerService.deleteOffer(offerId);
        return "redirect:/user/offers";
    }

    @RequestMapping(value = "/offers/edit", method = RequestMethod.POST )
    public String editOffer(@RequestParam("description") String offerDescription,@RequestParam("id")  Long offerId) {
        Offer oldOffer = offerService.getById(offerId);
        oldOffer.setDescription(offerDescription);
        offerService.updateOffer(oldOffer);
        return "redirect:/user/offers";
    }

    /*@RequestMapping(value = "/{offerId}/delete",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int deleteOffer(@PathVariable("offerId") Long offerId) {
        int status = -1;
        long loggedUserId = userService.getLoggedUserDetails().getUser().getId();
        if (offerService.getById(offerId).getUserId() == loggedUserId) {
            offerService.deleteOffer(offerId);
            status = 0;
        }
        return status;
    }*/
}

