package by.gergalov.max.course.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String getNotFoundPage() {
        return "404";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getForbiddenPage() {
        return "403";
    }
}
