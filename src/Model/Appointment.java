package Model;

import java.sql.Date;
/**
 * Represents an appointment in the real estate agency.
 */
public class Appointment implements HasID{
    private Integer id;
    private Date date;
    private Agent agentID;
    private Client clientID;
    private Property propertyID;
    /**
     * Constructs an Appointment object with the specified ID, date, agent, client, and property.
     *
     * @param id          The unique identifier of the appointment.
     * @param date        The date of the appointment.
     * @param agentID     The agent involved in the appointment.
     * @param clientID    The client involved in the appointment.
     * @param propertyID  The property involved in the appointment.
     */
    public Appointment(Integer id,Date date, Agent agentID, Client clientID, Property propertyID){
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
     * Constructs an Appointment object with the specified data.
     *
     * @param data The data of the appointment.
     */
    public Appointment(String[] data, Agent agentID, Client clientID, Property propertyID){
        this.id = Integer.parseInt(data[0]);
        this.date = Date.valueOf(data[1]);
        this.agentID = agentID;
        this.clientID = clientID;
        this.propertyID = propertyID;
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
    public Agent getAgentID() {
        return agentID;
    }
    /**
     * Sets the agent involved in the appointment.
     *
     * @param agentID The agent involved in the appointment.
     */
    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }
    /**
     * Gets the client involved in the appointment.
     *
     * @return The client involved in the appointment.
     */
    public Client getClientID() {
        return clientID;
    }
    /**
     * Sets the client involved in the appointment.
     *
     * @param clientID The client involved in the appointment.
     */
    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }
    /**
     * Gets the property involved in the appointment.
     *
     * @return The property involved in the appointment.
     */
    public Property getPropertyID() {
        return propertyID;
    }
    /**
     * Sets the property involved in the appointment.
     *
     * @param propertyID The property involved in the appointment.
     */
    public void setPropertyID(Property propertyID) {
        this.propertyID = propertyID;
    }
    /**
     * Returns a string representation of the appointment.
     *
     * @return A string containing the appointment's ID, date, agent, client, and property.
     */
    @Override
    public String toString(){
        return id + "," + date + "," + agentID + "," + clientID + "," + propertyID;
    }

//    @Override
//    public String toString() {
//        return "Appointment{" +
//                "id=" + id +
//                ", date=" + date +
//                ", agentID=" + agentID +
//                ", clientID=" + clientID +
//                ", propertyID=" + propertyID +
//                '}';
//    }
}
