package org.example.Model;
import java.sql.Date;
/**
 * Represents an appointment in the real estate agency.
 */
public class Appointment implements HasID {
    private Integer id;
    private Date date;
    private Integer agentID;
    private Integer clientID;
    private Integer propertyID;

    public Appointment(Integer id, Date date, Integer agentID, Integer clientID, Integer propertyID) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.date = date;
        this.agentID = agentID;
        this.clientID = clientID;
        this.propertyID = propertyID;
    }
    public Appointment(){
        //default constructor
    }
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    @Override
    public String toCsv() {
        return id + "," + date + "," + agentID + "," + clientID + "," + propertyID;
    }

    @Override
    public String toString() {
        return id+","+date+","+agentID+","+clientID+","+propertyID;
    }
}