package Model;

import java.sql.Date;
/**
 * Represents an appointment in the real estate agency.
 */
public class Appointment implements HasID{
    private Integer id;
    private Date date;
    private Integer agentID;
    private Integer clientID;
    private Integer propertyID;
    /**
     * Constructs an Appointment object with the specified ID, date, agent, client, and property.
     *
     * @param id          The unique identifier of the appointment.
     * @param date        The date of the appointment.
     * @param agentID     The agent involved in the appointment.
     * @param clientID    The client involved in the appointment.
     * @param propertyID  The property involved in the appointment.
     */
    public Appointment(Integer id,Date date, Integer agentID, Integer clientID, Integer propertyID){
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id=id;
        this.date=date;
        this.agentID=agentID;
        this.clientID=clientID;
        this.propertyID=propertyID;
    }
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
    public void setId(Integer id){
        this.id=id;
    }
    /**
     * Gets the date of the appointment.
     *
     * @return The date of the appointment.
     */
    public Date getDate(){
        return this.date;
    }
    /**
     * Sets the date of the appointment.
     *
     * @param date The date of the appointment.
     */
    public void setDate(Date date){
        this.date=date;
    }
    /**
     * Gets the agent involved in the appointment.
     *
     * @return The agent involved in the appointment.
     */
    public Integer getAgentID() {
        return agentID;
    }
    /**
     * Sets the agent involved in the appointment.
     *
     * @param agentID The agent involved in the appointment.
     */
    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }
    /**
     * Gets the client involved in the appointment.
     *
     * @return The client involved in the appointment.
     */
    public Integer getClientID() {
        return clientID;
    }
    /**
     * Sets the client involved in the appointment.
     *
     * @param clientID The client involved in the appointment.
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }
    /**
     * Gets the property involved in the appointment.
     *
     * @return The property involved in the appointment.
     */
    public Integer getPropertyID() {
        return propertyID;
    }
    /**
     * Sets the property involved in the appointment.
     *
     * @param propertyID The property involved in the appointment.
     */
    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }
    /**
     * Returns a string representation of the appointment.
     *
     * @return A string containing the appointment's ID, date, agent, client, and property.
     */
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", agentID=" + agentID +
                ", clientID=" + clientID +
                ", propertyID=" + propertyID +
                '}';
    }
}
