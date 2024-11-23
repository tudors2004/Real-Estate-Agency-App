package org.example.Model;
/**
 * Represents a review in the real estate agency, implementing the HasID interface.
 */
public class Review implements HasID{
    private Integer id;
    private int rating;
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
     * @param propertyID The property's ID associated with the review.
     * @param clientID  The client's ID who wrote the review.
     */
    public Review(Integer id, int rating, String comment, Integer propertyID, Integer clientID) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.propertyID = propertyID;
        this.clientID = clientID;
    }
    /**
     * Constructs a Review object meant for an Agent, with the specified ID, rating, comment, agent, and client.
     *
     * @param id      The unique identifier of the review.
     * @param rating  The rating of the review.
     * @param comment The comment of the review.
     * @param agentID The agent's ID associated with the review.
     * @param clientID  The client's ID who wrote the review.
     */
    public Review(Integer id, int rating, String comment, Integer agentID, Integer clientID, Integer propertyID) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.propertyID = null;
        this.clientID = clientID;
        this.agentID = agentID;
    }
    /**
     * Default constructor for the Review class.
     */
    public Review(){}
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
     * Gets the unique identifier of the property associated with the review.
     *
     * @return The unique identifier of the property associated with the review.
     */
    public Integer getPropertyID() {
        return propertyID;
    }
    /**
     * Sets the unique identifier of the property associated with the review.
     *
     * @param propertyID The unique identifier of the property associated with the review.
     */
    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }
    /**
     * Gets the unique identifier of the client associated with the review.
     *
     * @return The unique identifier of the client associated with the review.
     */
    public Integer getClientID() {
        return clientID;
    }
    /**
     * Sets the unique identifier of the client associated with the review.
     *
     * @param clientID The unique identifier of the client associated with the review.
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }
    /**
     * Gets the unique identifier of the agent associated with the review.
     *
     * @return The unique identifier of the agent associated with the review.
     */
    public Integer getAgentID() {
        return agentID;
    }
    /**
     * Sets the unique identifier of the agent associated with the review.
     *
     * @param agentID The unique identifier of the agent associated with the review.
     */
    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }
    /**
     * Returns a CSV representation of the review.
     * If the review is associated with a property, the CSV will include the property details.
     * Otherwise, it will include the agent details.
     *
     * @return A CSV string containing the review's ID, rating, comment, and either the property or agent, along with the client.
     */
    @Override
    public String toCsv() {
        if (propertyID != null) {
            return id + "," + rating + "," + comment + "," + propertyID + "," + clientID;
        } else {
            return id + "," + rating + "," + comment + "," + agentID + "," + clientID;
        }
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
            return id + "," + rating + "," + comment + "," + propertyID + "," + clientID;
        } else {
            return id + "," + rating + "," + comment + "," + agentID + "," + clientID;
        }
    }
}
