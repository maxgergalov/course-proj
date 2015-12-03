package by.gergalov.max.course.controllers.user;

import org.hibernate.validator.constraints.NotEmpty;

public class EditOfferForm {

    @NotEmpty
    public Long offerDescription;

    public Long getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(Long offerId) {
        this.offerDescription = offerDescription;
    }

}
