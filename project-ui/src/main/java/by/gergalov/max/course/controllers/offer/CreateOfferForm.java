package by.gergalov.max.course.controllers.offer;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateOfferForm {

    @NotEmpty
    public String title;

    @NotEmpty
    public String description;

    @NotEmpty
    public String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
