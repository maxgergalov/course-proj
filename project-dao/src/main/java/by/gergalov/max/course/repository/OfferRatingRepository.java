package by.gergalov.max.course.repository;

import by.gergalov.max.course.entity.OfferRating;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OfferRatingRepository extends JpaRepository<OfferRating, Long> {

    @Query("select avg(r.rate) from OfferRating r where  r.offerId = :offerId")
    Double getOfferRateMean(@Param("offerId")long offerId);


    @Query("select count(r) from OfferRating r where r.offerId = :offerId")
    int getOfferRateCount(@Param("offerId")Long offerId);


    @Query("select offer,(select avg(r.rate) from OfferRating r where  r.offerId = offer.id) as rating " +
            "from Offer as offer order by rating desc")
    List<Object[]> getTopRatedOffers(Pageable pageable);

    @Query("select r from OfferRating r where r.offerId = :offerId and r.voterId = :userId")
    OfferRating getUserOfferRate(@Param("offerId")Long offerId,@Param("userId")Long userId);
}
