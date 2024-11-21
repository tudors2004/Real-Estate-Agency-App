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

    public Review(Integer id, int rating, String comment, Integer propertyID, Integer clientID, Integer agentID) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.propertyID = propertyID;
        this.clientID = clientID;
        this.agentID = null;
    }
    public Review(Integer id, int rating, String comment, Integer agentID, Integer clientID) {
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
    public Review(){
        //default constructor
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

    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }

    @Override
    public String toCsv() {
        if (propertyID != null) {
            return id + "," + rating + "," + comment + "," + propertyID + "," + clientID;
        } else {
            return id + "," + rating + "," + comment + "," + agentID + "," + clientID;
        }
    }
}
