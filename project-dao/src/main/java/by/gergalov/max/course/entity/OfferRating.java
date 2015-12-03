package by.gergalov.max.course.entity;

import by.gergalov.max.course.common.rate.OfferRate;
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
@Table(name = "offer_rating",
        uniqueConstraints = { @UniqueConstraint(columnNames =
                { "offer_id", "voter_id" }) })
public class OfferRating {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "offer_id",nullable = false)
    private Long offerId;


    @Column(name = "voter_id", nullable = false)
    private Long voterId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rate",nullable = false)
    private OfferRate rate;

    public OfferRating(){

    }

    public OfferRating(Long offerId, Long voterId, OfferRate rate){
        this.offerId = offerId;
        this.rate = rate;
        this.voterId = voterId;
    }
}
