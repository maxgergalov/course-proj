package by.gergalov.max.course.service.offer;

import by.gergalov.max.course.entity.Offer;


public class OfferRatingStatistic {

    private Offer offer;

    private double rating;

    public OfferRatingStatistic(Offer offer, double rating) {
        this.offer = offer;
        this.rating = rating;
    }

    public Offer getOffer() {
        return offer;
    }

    public double getRating() {
        return rating;
    }
}
