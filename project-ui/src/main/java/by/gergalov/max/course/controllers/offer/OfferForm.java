package by.gergalov.max.course.controllers.offer;

/**
 * Created by Max on 14.08.14.
 */
public class OfferForm {
    long Id ;
    String title;
    String description;

    public long getId(){
        return Id;
    };

    public void setId(long Id){
        this.Id=Id;
    };

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
}
