package by.gergalov.max.course.entity;

import by.gergalov.max.course.common.roles.UserRole;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String mail;

    @Column
    private String password;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    @Cascade({CascadeType.DELETE})
    private List<UserRating> ratings;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    @Cascade({CascadeType.DELETE})
    private List<Offer> offers;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<OfferRequest> requests;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate", nullable = false)
    private UserRole role;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public User(String name, String mail, String password, UserRole userRole) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.role = userRole;
    }

    public User() {

    }

    public List<OfferRequest> getRequests() {
        return requests;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public String getMail() {
        return mail;
    }




}
