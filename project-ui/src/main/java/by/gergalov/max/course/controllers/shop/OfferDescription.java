package by.gergalov.max.course.controllers.shop;

import by.gergalov.max.course.entity.Offer;

public class OfferDescription {

    private Offer offer;

    private int commentsCount;

    private String mainImageUrl;

    private String description;

    private double rating;

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OfferDescription(Offer offer, int commentsCount, String mainImageUrl, double rating) {
        this.offer = offer;
        this.commentsCount = commentsCount;
        this.mainImageUrl = mainImageUrl;
        this.description = offer.getDescription().length() > 150 ? offer.getDescription().substring(0, 150) + "..." :
                offer.getDescription();
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
