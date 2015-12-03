package by.gergalov.max.course.repository;

import by.gergalov.max.course.common.rate.UserRate;
import by.gergalov.max.course.entity.User;
import by.gergalov.max.course.entity.UserRating;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRatingRepository extends JpaRepository<UserRating, Long> {

    @Query("select count(r) from UserRating r where r.rate= :rate  and r.userId = :userId")
     int getUserRateCount(@Param("userId")Long userId,@Param("rate")UserRate rate);

    @Query("select user,((select count(r) from UserRating r where r.rate='LIKE'  and r.userId = user.id ) -" +
            "(select count(r) from UserRating r where r.rate='DISLIKE'  and r.userId = user.id )) as delta,(select count(r) from UserRating r where r.rate='LIKE'  and r.userId = user.id ) as likes " +
            "from User as user order by delta desc, likes desc")
    List<Object[]> getTopRatedUser(Pageable pageable);
}