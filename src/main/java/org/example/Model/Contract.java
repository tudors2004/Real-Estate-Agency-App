package org.example.Model;
/**
 * Represents a contract in the real estate agency, implementing the HasID interface.
 */
public class Contract implements HasID {
    private Integer id;
    private ContractType type;
    private int duration;
    private Integer clientID;
    private Integer propertyID;
    /**
     * Constructs a Contract object with the specified ID, type, duration, agent ID, client ID, and property ID.
     *
     * @param id        The unique identifier of the contract.
     * @param type      The type of the contract.
     * @param duration  The duration of the contract.
     * @param clientID  The ID of the client associated with the contract.
     * @param propertyID The ID of the property associated with the contract.
     */
    public Contract(Integer id, ContractType type, int duration, Integer clientID, Integer propertyID) {
        if (id == null || id<=0) {
            throw new IllegalArgumentException("ID cannot be null or 0");
        }
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.clientID = clientID;
        this.propertyID = propertyID;
    }
    /**
     * Default constructor for the Contract class.
     */
    public Contract(){}
    /**
     * Gets the unique identifier of the contract.
     *
     * @return The unique identifier of the contract.
     */
    @Override
    public Integer getId() {
        return id;
    }
    /**
     * Sets the unique identifier of the contract.
     *
     * @param id The unique identifier of the contract.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Gets the type of the contract.
     *
     * @return The type of the contract.
     */
    public ContractType getType() {
        return type;
    }
    /**
     * Sets the type of the contract.
     *
     * @param type The type of the contract.
     */
    public void setType(ContractType type) {
        this.type = type;
    }
    /**
     * Gets the duration of the contract.
     *
     * @return The duration of the contract.
     */
    public int getDuration() {
        return duration;
    }
    /**
     * Sets the duration of the contract.
     *
     * @param duration The duration of the contract.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    /**
     * Gets the ID of the client associated with the contract.
     *
     * @return The ID of the client associated with the contract.
     */
    public Integer getClientID() {
        return clientID;
    }
    /**
     * Sets the ID of the client associated with the contract.
     *
     * @param clientID The ID of the client associated with the contract.
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }
    /**
     * Gets the ID of the property associated with the contract.
     *
     * @return The ID of the property associated with the contract.
     */
    public Integer getPropertyID() {
        return propertyID;
    }
    /**
     * Sets the ID of the property associated with the contract.
     *
     * @param propertyID The ID of the property associated with the contract.
     */
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
    /**
     * Converts the contract's details into a CSV (Comma-Separated Values) format.
     * The format includes ID, type, duration, agent ID, client ID, and property ID.
     *
     * @return The contract's details in CSV format.
     */
    @Override
    public String toCsv() {
        return id + "," +
                type + "," +
                duration + "," +
                clientID + "," +
                propertyID;
    }
    /**
     * Converts the contract's details into a string representation.
     *
     * @return The contract's details in string format.
     */
    @Override
    public String toString() {
        return id+","+type+","+duration+","+clientID+","+propertyID;
    }
}
