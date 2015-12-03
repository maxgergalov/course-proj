package by.gergalov.max.course.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "offerId")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    private List<OfferRating> ratings;

    @OneToMany(mappedBy = "offerId", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @Fetch(FetchMode.JOIN)
    private List<Image> images;

    @OneToMany(mappedBy = "offerId", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    @Fetch(FetchMode.JOIN)
    private List<Comment> comments;

    @Column(updatable = false)
    private Long userId;

    @Column(updatable = false)
    private Long projectId;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime creationDate;


    //http://stackoverflow.com/questions/13047483/hibernate-one-to-many-using-a-join-table-and-hibernate-annotations
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "offer_tags",
            joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    @Fetch(FetchMode.JOIN)
    private List<Tag> tags;

    @OneToMany(mappedBy = "offerId", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @Fetch(FetchMode.JOIN)
    private List<OfferRequest> requests;

    @Column(nullable = false)
    private String title;

    //http://stackoverflow.com/questions/16105903/float-mapping-precision-with-hibernate
//http://stackoverflow.com/questions/7755417/hibernate-bigdecimal-mapping-precision?lq=1
    @Column(name = "price", precision = 6, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Lob
    private String description;

    public Offer() {
        creationDate = new LocalDateTime();
    }

    public Offer(String title, BigDecimal price, String description, Long userId) {
        this();
        this.title = title;
        this.price = price;
        this.description = description;
        this.userId = userId;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<OfferRequest> getRequests() {
        return requests;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
