package Model;

import java.sql.Date;
import java.util.List;

public class Appointment implements HasID{
    private Integer id;
    private List<Agent> Agent_ID;
    private List<Client> Client_ID;
    private List<Property> Property_ID;
    private Date date;

    public Appointment(Integer id,Date date){
        this.id=id;
        this.date=date;
    }

    @Override
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public List<Agent> getAgent_ID(){
        return this.Agent_ID;
    }
    public void setAgent_ID(List<Agent> Agent_Id){
        this.Agent_ID=Agent_Id;
    }
    public List<Client> getClient_ID(){
        return this.Client_ID;
    }
    public void setClient_ID(List<Client> Client_id){
        this.Client_ID=Client_id;
    }
    public List<Property> getProperty_Id(){
        return this.Property_ID;
    }
    public void setProperty_ID(List<Property> Property_ID)
    {
        this.Property_ID=Property_ID;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date=date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", Agent_ID=" + Agent_ID +
                ", Client_ID=" + Client_ID +
                ", Property_ID=" + Property_ID +
                ", date=" + date +
                '}';
    }
}
