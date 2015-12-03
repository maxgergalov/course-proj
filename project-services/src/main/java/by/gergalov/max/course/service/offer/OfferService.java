package by.gergalov.max.course.service.offer;

import by.gergalov.max.course.common.rate.OfferRate;
import by.gergalov.max.course.entity.Image;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.OfferRating;
import by.gergalov.max.course.entity.OfferRequest;
import by.gergalov.max.course.service.common.BaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface OfferService extends BaseService<Offer> {

    Offer registerOffer(Offer offer);

    void deleteOffer(Long offerId);

    Offer updateOffer(Offer offer);

    List<Offer> getUserOffers(Long userId);

    OfferRating addOfferRate(Long offerId, Long votedUserId, OfferRate rate);

    Map<Integer, Integer> getOfferRateSpectre(Long offerId);

    Double getOfferRateMean(Long offerId);

    int getOfferRateCount(Long offerId);

    public Image saveImage(MultipartFile file, Long offerId);

    List<OfferRatingStatistic> getTopRatedOffers(int offerCount);

    List<OfferRatingStatistic> getLastOffers(int offerCount);

    OfferRating getUserOfferRate(Long offerId, Long userId);

    OfferRequest addOfferRequest(Long offerId, Long userId);

    OfferRating getOfferRequest(Long offerId, Long userId);
}
