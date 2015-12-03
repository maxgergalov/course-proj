package by.gergalov.max.course.repository;

import by.gergalov.max.course.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByOfferId(Long offerId);


    //http://stackoverflow.com/questions/10448935/hql-error-path-expected-for-join
    @Query("select comment from  Offer offer inner join  offer.comments comment where offer.id = comment.offerId and offer.userId = :userId")
    List<Comment> findByUserId(@Param("userId") Long userId);

    @Query("select count(comment) from Offer offer inner join offer.comments comment where comment.offerId= :offerId")
    int getOffersCommentCount(@Param("offerId") Long offerId);

}
