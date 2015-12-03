package by.gergalov.max.course.repository;

import by.gergalov.max.course.entity.Offer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findByUserId(Long userId);

    @Query("select offer,(select avg(r.rate) from OfferRating r where  r.offerId = offer.id) as rating " +
            "from Offer as offer order by offer.creationDate desc")
    List<Object[]> getLastOffers(Pageable pageable);

}
