package by.gergalov.max.course.entity;

import by.gergalov.max.course.common.rate.UserRate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "user_rating",
        uniqueConstraints = { @UniqueConstraint(columnNames =
                { "user_id", "voter_id" }) })
public class UserRating {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "voter_id",nullable = false)
    private Long voterId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRate rate;

    public UserRating(){

    }

    public UserRating(Long userId, Long voterId, UserRate rate){
        this.userId = userId;
        this.rate = rate;
        this.voterId = voterId;
    }
}
