package by.gergalov.max.course.service.offer;

import by.gergalov.max.course.common.rate.OfferRate;
import by.gergalov.max.course.entity.Image;
import by.gergalov.max.course.entity.Offer;
import by.gergalov.max.course.entity.OfferRating;
import by.gergalov.max.course.entity.OfferRequest;
import by.gergalov.max.course.repository.*;
import com.cloudinary.Cloudinary;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    OfferRatingRepository offerRatingRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    OfferRequestRepository requestRepository;
    @Autowired
    Cloudinary cloudinary;

    private boolean checkOfferRequestsAge = false;
    private final int offerRequestsCheckInterval = 60000;

    @Override
    public Offer registerOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerRepository.delete(offerId);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        Offer newOffer = offerRepository.save(offer);
        offerRepository.flush();
        return newOffer;
    }

    @Override
    public OfferRating addOfferRate(Long offerId, Long votedUserId, OfferRate rate) {
        OfferRating offerRating = new OfferRating(offerId, votedUserId, rate);
        return offerRatingRepository.save(offerRating);
    }

    @Override
    public List<Offer> getUserOffers(Long userId) {
        return offerRepository.findByUserId(userId);
    }

    @Override
    public Map<Integer, Integer> getOfferRateSpectre(Long offerId) {
        // TODO version 2.0
        return null;
    }

    @Override
    public Double getOfferRateMean(Long offerId) {
        return offerRatingRepository.getOfferRateMean(offerId);
    }

    @Override
    public int getOfferRateCount(Long offerId) {
        return offerRatingRepository.getOfferRateCount(offerId);
    }

    @Override
    public long count() {
        return offerRepository.count();
    }

    @Override
    public Image saveImage(MultipartFile file, Long offerId) {
        if (file == null) {
            return null;
        }
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Cloudinary.asMap("resource_type", "auto"));
            Image image = new Image(uploadResult.get("url").toString(),offerId);

            return image;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Offer getById(long id) {
        return offerRepository.findOne(id);
    }

    @Override
    public List<OfferRatingStatistic> getTopRatedOffers(int offerCount) {
        Pageable filter = new PageRequest(0, offerCount);
        List<OfferRatingStatistic> statistics = new ArrayList<OfferRatingStatistic>(offerCount);
        for (Object[] objects : offerRatingRepository.getTopRatedOffers(filter)) {
            statistics.add(new OfferRatingStatistic((Offer) objects[0], (Double) objects[1]));
        }
        return statistics;
    }

    @Override
    public List<OfferRatingStatistic> getLastOffers(int offerCount) {
        Pageable filter = new PageRequest(0, offerCount);
        List<OfferRatingStatistic> statistics = new ArrayList<OfferRatingStatistic>(offerCount);
        for (Object[] objects : offerRepository.getLastOffers(filter)) {
            Offer offer = (Offer) objects[0];
            double rating = 0;
            if(objects[1]!=null){
                rating = (Double) objects[1];
            }
            statistics.add(new OfferRatingStatistic(offer, rating));
        }
        return statistics;
    }

    @Override
    public OfferRating getUserOfferRate(Long offerId, Long userId) {
        return offerRatingRepository.getUserOfferRate(offerId, userId);
    }

    @Override
    public OfferRequest addOfferRequest(Long offerId, Long userId) {
        return requestRepository.saveAndFlush(new OfferRequest(offerId, userId));
    }

    //http://stackoverflow.com/questions/5467275/how-to-call-a-spring-controller-at-every-specific-time-intervals
    @Scheduled(fixedRate = offerRequestsCheckInterval)
    public void checkOfferRequestAge() {
        if (checkOfferRequestsAge) {
            for (OfferRequest request : requestRepository.findAll()) {
                if (new Interval(new DateTime().minusMillis(offerRequestsCheckInterval),
                        new DateTime()).contains(request.getCreationDate().toDateTime())) {
                    requestRepository.delete(request.getId());
                }
            }
        }
    }

    @Override
    public OfferRating getOfferRequest(Long offerId, Long userId) {
        return requestRepository.getOfferRequest(offerId,userId);
    }

    public boolean isCheckOfferRequestsAge() {
        return checkOfferRequestsAge;
    }

    public void setCheckOfferRequestsAge(boolean checkOfferRequestsAge) {
        this.checkOfferRequestsAge = checkOfferRequestsAge;
    }
}
