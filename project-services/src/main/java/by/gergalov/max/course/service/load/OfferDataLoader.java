package by.gergalov.max.course.service.load;


import by.gergalov.max.course.common.rate.OfferRate;
import by.gergalov.max.course.common.roles.UserRole;
import by.gergalov.max.course.entity.Image;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.service.offer.OfferService;
import by.gergalov.max.course.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class OfferDataLoader {


    @Autowired
    private UserService userService;
    @Autowired
    private OfferService offerService;

    private Offer defaultOffer = null;
    private final String description = "Душа моя озарена неземной радостью, как эти чудесные весенние утра, которыми я наслаждаюсь от всего сердца. Я совсем один и блаженствую в здешнем краю, словно созданном для таких, как я.\n" +
            "\n" +
            "Я так счастлив, мой друг, так упоен ощущением покоя, что искусство мое страдает от этого. Ни одного штриха не мог бы я сделать, а никогда не был таким большим художником, как в эти минуты. Когда от милой моей долины поднимается пар и полдневное солнце стоит над непроницаемой чащей темного леса ";

    private String firstUrl = "http://cs616119.vk.me/v616119147/168aa/UDECWSYv8f0.jpg";
    private String secondUrl = "http://cs616119.vk.me/v616119147/168b3/l0tx1Thn1eE.jpg";
    private String thirdUrl = "http://cs616119.vk.me/v616119147/168bc/pbAbW53hS14.jpg";
    private String fifthUrl = "http://cs616119.vk.me/v616119147/168c5/4mQ98SYr2sc.jpg";
    private String fourUrl = "http://cs616119.vk.me/v616119147/168ce/VdRX0xFo3Lo.jpg";

    Random random = new Random();

    public Offer getOne() {
        if (defaultOffer == null) {
            User user = userService.registerUser(new User("offer", "offer@gmail.com", "offer", UserRole.ROLE_USER));
            defaultOffer = offerService.registerOffer(new Offer("title", new BigDecimal(4.32), "description", user.getId()));
        }
        return defaultOffer;
    }

    public void cleanOne() {
        userService.deleteUser(getOne().getUserId());
        defaultOffer = null;
    }


    public List<Offer> getOffers(int count, Long userId) {
        List<Offer> offers = new ArrayList<Offer>(5);
        for (int i = 0; i < count; i++) {
            String title = "title" + i;
            Offer offer = offerService.registerOffer(new Offer(title, new BigDecimal(random.nextDouble()), description, userId));
            offer.setImages(Arrays.asList(new Image(getRandomUrl(random.nextInt(6)),offer.getId())));
            offers.add(offerService.updateOffer(offer));
        }
        return offers;
    }

    public void addRatingToOffer(List<User> users, List<OfferRate> rates, Long offerId) {
        for (int i = 0; i < rates.size() && i < users.size(); i++) {
            offerService.addOfferRate(offerId, users.get(i).getId(), rates.get(i));
        }
    }

    public List<OfferRate> getRandomRatings(int count) {
        List<OfferRate> rates = new ArrayList<OfferRate>(count);
        for (int i = 0; i < count; i++) {
            rates.add(getOfferRateByStarsCount(random.nextInt(6)));
        }
        return rates;
    }

    private OfferRate getOfferRateByStarsCount(int n) {
        OfferRate rate;
        switch (n) {
            case 1:
                rate = OfferRate.ONE;
                break;
            case 2:
                rate = OfferRate.TWO;
                break;
            case 3:
                rate = OfferRate.THREE;
                break;
            case 4:
                rate = OfferRate.FOUR;
                break;
            case 5:
                rate = OfferRate.FIVE;
                break;
            default:
                rate = OfferRate.ZERO;
        }
        return rate;
    }

    private String getRandomUrl(int n){
        String url;
        switch (n) {
            case 1:
                url = firstUrl;
                break;
            case 2:
                url = secondUrl;
                break;
            case 3:
                url = thirdUrl;
                break;
            case 4:
                url = fourUrl;
                break;
            default:
                url = fifthUrl;
        }
        return url;
    }
}
