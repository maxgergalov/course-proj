package by.gergalov.max.course.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "offer_request",
        uniqueConstraints = { @UniqueConstraint(columnNames =
                { "offer_id", "user_id" }) })
public class OfferRequest {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "offer_id",nullable = false)
    private Long offerId;
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime creationDate;


    public OfferRequest(Long userId, Long offerId) {
        this.userId = userId;
        this.offerId = offerId;
    }

    public OfferRequest() {
        creationDate = new LocalDateTime();
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }
}
