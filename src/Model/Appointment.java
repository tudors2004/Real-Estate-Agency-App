package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Appointment implements HasID{
    private Integer id;
//    private List<Agent> Agent_ID;
//    private List<Client> Client_ID;
//    private List<Property> Property_ID;
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
//    public List<Agent> getAgent_ID(){
//        return this.Agent_ID;
//    }
//    public void setAgent_ID(List<Agent> Agent_Id){
//        this.Agent_ID=Agent_Id;
//    }
//    public List<Client> getClient_ID(){
//        return this.Client_ID;
//    }
//    public void setClient_ID(List<Client> Client_id){
//        this.Client_ID=Client_id;
//    }
//    public List<Property> getProperty_Id(){
//        return this.Property_ID;
//    }
//    public void setProperty_ID(List<Property> Property_ID)
//    {
//        this.Property_ID=Property_ID;
//    }
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
