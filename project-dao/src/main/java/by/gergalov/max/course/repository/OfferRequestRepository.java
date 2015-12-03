package by.gergalov.max.course.repository;


import by.gergalov.max.course.entity.OfferRating;
import by.gergalov.max.course.entity.OfferRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@SuppressWarnings("JpaQlInspection")
public interface OfferRequestRepository extends JpaRepository<OfferRequest, Long> {

    @Query("select r from OfferRequest as r where r.offerId = :offerId and r.userId = :userId")
    OfferRating getOfferRequest(@Param("offerId")Long offerId,@Param("userId")Long userId);
}
