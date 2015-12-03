package by.gergalov.max.course.controllers.notion;

import by.gergalov.max.course.controllers.offer.CreateOfferForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notion")
public class NotionController {

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String createOfferPage(Model model) {
        return "/result";
    }

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public ModelAndView createOffer() {
        return new ModelAndView("/parse");
    }
}

