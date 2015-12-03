package by.gergalov.max.course.controllers.notion;

import by.gergalov.max.course.controllers.offer.CreateOfferForm;
import by.gergalov.max.course.service.notion.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notion")
public class NotionController {

    @Autowired
    private NotionService notionService;

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getResultAfterParse(Model model) {
        return "/result";
    }

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public ModelAndView parse() {
        notionService.parse();
        return new ModelAndView("/parse");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getNotionMenu(Model model) {
        return "/result";
    }
}

