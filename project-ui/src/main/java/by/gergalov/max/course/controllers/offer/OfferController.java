package by.gergalov.max.course.controllers.offer;

import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.repository.OfferRepository;
import by.gergalov.max.course.service.generation.GenerationService;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@Controller
public class OfferController {

    @Autowired
    UserService userService;
    @Autowired
    GenerationService generationService;
    @Autowired
    OfferService offerService;
    @Autowired
    OfferRepository offerRepository;

    @RequestMapping(value = "/createOffer", method = RequestMethod.GET)
    public String createOfferPage(Model model) {
        model.addAttribute("CreateOfferForm", new CreateOfferForm());
        return "/createOffer";
    }

    @RequestMapping(value = "/createOffer/create", method = RequestMethod.POST)
    public ModelAndView createOffer(@Valid @ModelAttribute("CreateOfferForm") CreateOfferForm form, BindingResult result, ModelMap model,@RequestParam("textbox") MultipartFile[] file) {
        if (!result.hasErrors()) {

            String strin="";
            try {

                String str = "";
                BufferedReader in;
                in = new BufferedReader(new FileReader("F:/CourseProject/codex/project-ui/src/main/webapp/resources/qwe.txt"));

                while ((str = in.readLine()) != null)
                {
                    System.out.println(str);
                    strin += str;

                    // process(str);
                }
            } catch (IOException e) {
            }

            Long userId = userService.getLoggedUserDetails().getUser().getId();
            //Offer offer = offerService.registerOffer(new Offer(form.getTitle(), new BigDecimal(form.getPrice()), form.getDescription(), userId));
            Offer offer = offerService.registerOffer(new Offer(form.getTitle(), new BigDecimal(form.getPrice()), strin, userId));

            offer.setImages(Arrays.asList(offerService.saveImage(file[0],offer.getId())));
            offerService.updateOffer(offer);
            offerRepository.save(offer);


            return new ModelAndView("redirect:/shop");
        }
        return new ModelAndView("/shop");
    }
}
