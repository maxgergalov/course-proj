package by.gergalov.max.course.controllers.admin;

import by.gergalov.max.course.controllers.offer.OfferForm;
import by.gergalov.max.course.controllers.shop.ShopControllerLogic;
import by.gergalov.max.course.controllers.user.UserForm;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.repository.OfferRepository;
import by.gergalov.max.course.repository.UserRepository;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by Max on 14.08.14.
 */
@Controller
@RequestMapping(value = "/test")
public class QerweController {
    @Autowired
    OfferService offerService;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ShopControllerLogic logic;

    @RequestMapping(value = "/qwe", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HashMap get() {
        User user = userService.getLoggedUserDetails().getUser();

        HashMap<String,Object> rez = new HashMap<String, Object>();
        rez.put("adminOffers", offerService.getUserOffers(user.getId()));
        rez.put("adminRequests", user.getRequests());
        rez.put("howOffers",offerService.count());
        rez.put("howUsers",userService.count());
        rez.put("allUsers", userService.getAllUsers());
        rez.put("lastOffers", logic.getOfferDescriptions(9));
        return rez;
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    HashMap getShop() {
        HashMap<String,Object> rez = new HashMap<String, Object>();

        rez.put("lastOffers", logic.getOfferDescriptions(20));

        return rez;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String editOffer(@RequestBody OfferForm offerForm) {
        Offer oldOffer = offerService.getById(offerForm.getId());
        oldOffer.setDescription(offerForm.getDescription());
        oldOffer.setTitle(offerForm.getTitle());
        offerService.updateOffer(oldOffer);
        return "{}";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String saveUser(@RequestBody UserForm userForm) {
        User oldUser = userService.getById(userForm.getId());
        oldUser.setName(userForm.getName());
        oldUser.setPassword(userForm.getPassword());
        userService.updateUser(oldUser);
        return "{}";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String deleteOffer(@RequestBody OfferForm offerForm) {
        offerService.deleteOffer(offerForm.getId());
        return "{}";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    String deleteUser(@RequestBody UserForm userForm) {
        userService.deleteUser(userForm.getId());
        return "{}";
    }

}
