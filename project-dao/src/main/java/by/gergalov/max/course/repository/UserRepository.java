package by.gergalov.max.course.repository;

import by.gergalov.max.course.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByMail(String mail);

    @Query("select user from User as user where user.id in :userIds")
    List<User> getUsers(@Param("userIds") List<Long> userIds);

}
