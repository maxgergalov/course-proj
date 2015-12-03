package by.gergalov.max.course.controllers.item;

import by.gergalov.max.course.entity.Comment;
import by.gergalov.max.course.entity.Offer;

import java.util.List;


public class ItemDescription {

    private String imageUrl;
    private double rating;
    private Offer offer;
    private List<Comment> comments;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
