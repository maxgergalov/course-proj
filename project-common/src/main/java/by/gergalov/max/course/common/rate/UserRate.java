package by.gergalov.max.course.common.rate;


public enum UserRate {
    LIKE(1), DISLIKE(-1);

    int rate;

    public int getRate() {
        return rate;
    }

    private UserRate(int rate) {
        this.rate = rate;
    }

}
