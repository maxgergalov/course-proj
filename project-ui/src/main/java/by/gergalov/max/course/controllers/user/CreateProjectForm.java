package by.gergalov.max.course.controllers.user;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateProjectForm {

    @NotEmpty
    public Long offerId;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

}
