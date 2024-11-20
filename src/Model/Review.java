package Model;
/**
 * Represents a review in the real estate agency, implementing the HasID interface.
 */
public class Review implements HasID{
    private Integer id;
    private Integer rating;
    private String comment;
    private Integer propertyID;
    private Integer clientID;
    private Integer agentID;
    /**
     * Constructs a Review object meant for a Property, with the specified ID, rating, comment, property, and client.
     *
     * @param id      The unique identifier of the review.
     * @param rating  The rating of the review.
     * @param comment The comment of the review.
     * @param property The property associated with the review.
     * @param client  The client who wrote the review.
     */
    public Review(Integer id, Integer rating, String comment, Integer property, Integer client) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.propertyID = property;
        this.clientID = client;
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
    public Review(Integer agent, Integer client,Integer id, Integer rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.agentID = agent;
        this.clientID= client;
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
    public Integer getProperty() {
        return propertyID;
    }
    /**
     * Sets the property associated with the review.
     *
     * @param property The property associated with the review.
     */
    public void setProperty(Integer property) {
        this.propertyID = property;
    }
    /**
     * Gets the client who wrote the review.
     *
     * @return The client who wrote the review.
     */
    public Integer getClient() {
        return clientID;
    }
    /**
     * Sets the client who wrote the review.
     *
     * @param client The client who wrote the review.
     */
    public void setClient(Integer client) {
        this.clientID = client;
    }
    /**
     * Gets the agent associated with the review.
     *
     * @return The agent associated with the review.
     */
    public Integer getAgent(){
        return agentID;
    }
    /**
     * Sets the agent associated with the review.
     *
     * @param agent The agent associated with the review.
     */
    public void setAgent(Integer agent){
        this.agentID=agent;
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
        if (propertyID != null) {
            return "Review{" +
                    "id=" + id +
                    ", rating=" + rating + " Stars" +
                    ", comment='" + comment + '\'' +
                    ", property=" + propertyID +
                    ", client=" + clientID +
                    '}';
        } else {
            return "Review{" +
                    "id=" + id +
                    ", rating=" + rating + " Stars" +
                    ", comment='" + comment + '\'' +
                    ", agent=" + agentID +
                    ", client=" + clientID +
                    '}';
        }
    }
}