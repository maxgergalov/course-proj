package by.gergalov.max.course.common.rate;


public enum OfferRate {
    //stars
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private int score;

    private OfferRate(int score) {
        this.score = score;
    }

    public static OfferRate getOfferRateByScore(int score) {
        for (OfferRate rate : OfferRate.values()) {
            if (rate.score == score) {
                return rate;
            }
        }
        return ZERO;
    }

}
