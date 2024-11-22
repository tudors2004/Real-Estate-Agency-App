package org.example.Model;
/**
 * Represents a contract in the real estate agency, implementing the HasID interface.
 */
public class Contract implements HasID {
    private Integer id;
    private ContractType type;
    private int duration;
    private Integer agentID;
    private Integer clientID;
    private Integer propertyID;

    public Contract(Integer id, ContractType type, int duration, Integer agentID, Integer clientID, Integer propertyID) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.agentID = agentID;
        this.clientID = clientID;
        this.propertyID = propertyID;
    }
    public Contract(){
        //default constructor
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

    /**
     * Enum representing the type of the contract.
     */
    public enum ContractType {
        PURCHASE,
        LEASE,
        RENTAL
    }

    @Override
    public String toCsv() {
        return id + "," +
                type + "," +
                duration + "," +
                agentID + "," +
                clientID + "," +
                propertyID;
    }

    @Override
    public String toString() {
        return id+","+type+","+duration+","+agentID+","+clientID+","+propertyID;
    }
}
