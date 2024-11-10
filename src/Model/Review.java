package Model;
/**
 * Represents a review in the real estate agency, implementing the HasID interface.
 */
public class Review implements HasID{
    private Integer id;
    private int rating;
    private String comment;
    private Property property;
    private Client client;
    private Agent agent;
    /**
     * Constructs a Review object meant for a Property, with the specified ID, rating, comment, property, and client.
     *
     * @param id      The unique identifier of the review.
     * @param rating  The rating of the review.
     * @param comment The comment of the review.
     * @param property The property associated with the review.
     * @param client  The client who wrote the review.
     */
    public Review(Integer id, int rating, String comment, Property property, Client client) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.property = property;
        this.client = client;
    }
    /**
     * Constructs a Review object meant for an Agent, with the specified ID, rating, comment, agent, and client.
     *
     * @param id      The unique identifier of the review.
     * @param rating  The rating of the review.
     * @param comment The comment of the review.
     * @param agent The agent associated with the review.
     * @param client  The client who wrote the review.
     */
    public Review(Integer id, int rating, String comment, Agent agent, Client client) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.agent = agent;
        this.client = client;
    }
    /**
     * Gets the unique identifier of the review.
     *
     * @return The unique identifier of the review.
     */
    @Override
    public Integer getId() {
        return id;
    }
    /**
     * Sets the unique identifier of the review.
     *
     * @param id The unique identifier of the review.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Gets the rating of the review.
     *
     * @return The rating of the review.
     */
    public int getRating() {
        return rating;
    }
    /**
     * Sets the rating of the review.
     *
     * @param rating The rating of the review.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * Gets the comment of the review.
     *
     * @return The comment of the review.
     */
    public String getComment() {
        return comment;
    }
    /**
     * Sets the comment of the review.
     *
     * @param comment The comment of the review.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    /**
     * Gets the property associated with the review.
     *
     * @return The property associated with the review.
     */
    public Property getProperty() {
        return property;
    }
    /**
     * Sets the property associated with the review.
     *
     * @param property The property associated with the review.
     */
    public void setProperty(Property property) {
        this.property = property;
    }
    /**
     * Gets the client who wrote the review.
     *
     * @return The client who wrote the review.
     */
    public Client getClient() {
        return client;
    }
    /**
     * Sets the client who wrote the review.
     *
     * @param client The client who wrote the review.
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * Gets the agent associated with the review.
     *
     * @return The agent associated with the review.
     */
    public Agent getAgent(){
        return agent;
    }
    /**
     * Sets the agent associated with the review.
     *
     * @param agent The agent associated with the review.
     */
    public void setAgent(Agent agent){
        this.agent=agent;
    }
    /**
     * Returns a string representation of the review.
     * If the review is associated with a property, the string will include the property details.
     * Otherwise, it will include the agent details.
     *
     * @return A string containing the review's ID, rating, comment, and either the property or agent, along with the client.
     */
    @Override
    public String toString() {
        if (property != null) {
            return "Review{" +
                    "id=" + id +
                    ", rating=" + rating + " Stars" +
                    ", comment='" + comment + '\'' +
                    ", property=" + property +
                    ", client=" + client +
                    '}';
        } else {
            return "Review{" +
                    "id=" + id +
                    ", rating=" + rating + " Stars" +
                    ", comment='" + comment + '\'' +
                    ", agent=" + agent +
                    ", client=" + client +
                    '}';
        }
    }
}