package by.gergalov.max.course.controllers.item;


public class AddRatingRequest {

    private long offerId;
    private int score;

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public AddRatingRequest(long offerId, int score) {
        this.offerId = offerId;
        this.score = score;
    }

    public AddRatingRequest() {
    }
}
