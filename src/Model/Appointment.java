package Model;

import java.sql.Date;

public class Appointment implements HasID{
    private Integer id;
    private Date date;
    private Agent agentID;
    private Client clientID;
    private Property propertyID;

    public Appointment(Integer id,Date date, Agent agentID, Client clientID, Property propertyID){
        this.id=id;
        this.date=date;
        this.agentID=agentID;
        this.clientID=clientID;
        this.propertyID=propertyID;
    }

    @Override
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date=date;
    }

    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    public Property getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Property propertyID) {
        this.propertyID = propertyID;
    }

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
