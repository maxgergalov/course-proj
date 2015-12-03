package by.gergalov.max.course.controllers.root;

import by.gergalov.max.course.common.roles.UserRole;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.generation.GenerationService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class RootController {

    @Autowired
    UserService userService;
    @Autowired
    GenerationService generationService;

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/generation")
    public String generation() {
        try {
            generationService.generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "shop";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "/registration";
    }

    @RequestMapping(value = "/registration/create", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("registrationForm") RegistrationForm form, BindingResult result, ModelMap model) {
        if (!result.hasErrors()) {
            if(form.getPassword().equals(form.getConfirmationPassword())){
                User user = userService.registerUser(new User(form.getName(),form.getMail(),form.getPassword(),UserRole.ROLE_USER));
                model.put("user",user);
                return new ModelAndView("redirect:/shop");
            }
        }
        return new ModelAndView("/registration");
    }
}
