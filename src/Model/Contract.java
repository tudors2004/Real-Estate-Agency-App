package Model;
import java.util.List;
public class Contract implements HasID {
    private Integer id;
    private ContractType type;
    private int duration;
    private Agent agent;
    private Client client;
    private Property property;

    public Contract(Integer id, ContractType type, int duration, Agent agent, Client client, Property property) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.agent = agent;
        this.client = client;
        this.property = property;
    }

    public enum ContractType {
        PURCHASE,
        LEASE,
        RENTAL
    }


    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContractType getType() {
        return type;
    }

    public void setType(ContractType type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", duration=" + duration + " months"+
                ", agent=" + agent +
                ", client=" + client +
                ", property=" + property +
                '}';
    }
}