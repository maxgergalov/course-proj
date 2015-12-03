package by.gergalov.max.course.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false,unique = true)
    private Long offerId;

    public Image(String url, Long offerId) {

        this.url = url;
        this.offerId = offerId;
    }

    public Image() {
    }

    public String getUrl() {
        return url;
    }

    public Long getOfferId() {
        return offerId;
    }

    public Long getId() {
        return id;
    }
}
