package org.example.Model;
import java.sql.Date;
/**
 * Represents an appointment in the real estate agency.
 */
public class Appointment implements HasID {
    private Integer id;
    private Date date;
    private Integer clientID;
    private Integer propertyID;
    /**
     * Constructs an Appointment object with the specified ID, date, agent ID, client ID, and property ID.
     *
     * @param id        The unique identifier of the appointment.
     * @param date      The date of the appointment.
     * @param clientID  The ID of the client associated with the appointment.
     * @param propertyID The ID of the property associated with the appointment.
     */
    public Appointment(Integer id, Date date, Integer clientID, Integer propertyID) {
        if (id == null || id<=0) {
            throw new IllegalArgumentException("ID cannot be null or 0");
        }
        this.id = id;
        this.date = date;
        this.clientID = clientID;
        this.propertyID = propertyID;
    }
    /**
     * Default constructor for the Appointment class.
     */
    public Appointment(){}
    /**
     * Gets the unique identifier of the appointment.
     *
     * @return The unique identifier of the appointment.
     */
    @Override
    public Integer getId() {
        return id;
    }
    /**
     * Sets the unique identifier of the appointment.
     *
     * @param id The unique identifier of the appointment.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Gets the date of the appointment.
     *
     * @return The date of the appointment.
     */
    public Date getDate() {
        return date;
    }
    /**
     * Sets the date of the appointment.
     *
     * @param date The date of the appointment.
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Gets the ID of the client associated with the appointment.
     *
     * @return The ID of the client associated with the appointment.
     */
    public Integer getClientID() {
        return clientID;
    }
    /**
     * Sets the ID of the client associated with the appointment.
     *
     * @param clientID The ID of the client associated with the appointment.
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }
    /**
     * Gets the ID of the property associated with the appointment.
     *
     * @return The ID of the property associated with the appointment.
     */
    public Integer getPropertyID() {
        return propertyID;
    }
    /**
     * Sets the ID of the property associated with the appointment.
     *
     * @param propertyID The ID of the property associated with the appointment.
     */
    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }
    /**
     * Converts the appointment's details into a CSV (Comma-Separated Values) format.
     * The format includes ID, date, agent ID, client ID, and property ID.
     *
     * @return a string representation of the appointment in CSV format
     */
    @Override
    public String toCsv() {
        return id + "," + date + "," + clientID + "," + propertyID;
    }
    /**
     * Converts the appointment's details into a string representation.
     * The format includes ID, date, agent ID, client ID, and property ID.
     *
     * @return a string representation of the appointment
     */
    @Override
    public String toString() {
        return id+","+date+","+clientID+","+propertyID;
    }
}