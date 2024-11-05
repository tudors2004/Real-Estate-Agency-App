package Model;

public class Review implements HasID{
    private Integer id;
    private int rating;
    private String comment;
    private Property property;
    private Client client;

    public Review(Integer id, int rating, String comment, Property property, Client client) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.property = property;
        this.client = client;
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

    public void setRating(int rating) {
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
}