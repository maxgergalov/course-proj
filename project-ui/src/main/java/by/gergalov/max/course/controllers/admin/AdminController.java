package by.gergalov.max.course.controllers.admin;

import by.gergalov.max.course.controllers.user.UserControllerLogic;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.repository.OfferRepository;
import by.gergalov.max.course.repository.UserRepository;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserControllerLogic logic;
    @Autowired
    UserService userService;
    @Autowired
    OfferService offerService;
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ModelAndView getOffersPage() {
        ModelAndView model = new ModelAndView("admin/tasks");
        User user = userService.getLoggedUserDetails().getUser();
        model.addObject("adminOffers", user.getOffers());
        model.addObject("adminRequests", user.getRequests());

        model.addObject("howOffers",offerService.count());

        model.addObject("howUsers",userService.count());

        return model;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getRequestsPage() {
        ModelAndView model = new ModelAndView("/admin/users");
        User user = userService.getLoggedUserDetails().getUser();
        model.addObject("adminUsers", user.getOffers());
        //model.addObject("adminUsers", user.getUsers());
        return model;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ModelAndView getProjectsPage() {
        ModelAndView model = new ModelAndView("/admin/projects");
        User user = userService.getLoggedUserDetails().getUser();
        model.addObject("adminUsers", user.getOffers());
        //model.addObject("adminUsers", user.getUsers());
        return model;
    }
}

