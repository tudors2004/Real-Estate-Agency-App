package Model;

import java.util.List;

public class Review implements HasID{
    private Integer id;
    private int rating;
    private String comment;
    private Property property;
    private Client client;
    private Integer Rating;

    public Review(Integer id,Integer Rating, String comment, Property property, Client client) {
        this.id = id;
        this.comment = comment;
        this.property = property;
        this.client = client;
        this.Rating = Rating;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        if(rating<1 || rating>5){
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating + " Stars"+
                ", comment='" + comment + '\'' +
                ", property=" + property +
                ", client=" + client +
                '}';
    }
}