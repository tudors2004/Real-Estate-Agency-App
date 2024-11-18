package Model;
/**
 * Represents a contract in the real estate agency, implementing the HasID interface.
 */
public class Contract implements HasID {
    private Integer id;
    private ContractType type;
    private int duration;
    private Agent agent;
    private Client client;
    private Property property;
    /**
     * Constructs a Contract object with the specified ID, type, duration, agent, client, and property.
     *
     * @param id       The unique identifier of the contract.
     * @param type     The type of the contract.
     * @param duration The duration of the contract.
     * @param agent    The agent involved in the contract.
     * @param client   The client involved in the contract.
     * @param property The property involved in the contract.
     */
    public Contract(Integer id, ContractType type, int duration, Agent agent, Client client, Property property) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.agent = agent;
        this.client = client;
        this.property = property;
    }
    public Contract(String[] data, Agent agent, Client client, Property property) {
        this.id = Integer.parseInt(data[0]);
        this.type = ContractType.valueOf(data[1]);
        this.duration = Integer.parseInt(data[2]);
        this.agent = agent;
        this.client = client;
        this.property = property;
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
     * Gets the agent involved in the contract.
     *
     * @return The agent involved in the contract.
     */
    public Agent getAgent() {
        return agent;
    }
    /**
     * Sets the agent involved in the contract.
     *
     * @param agent The agent involved in the contract.
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    /**
     * Gets the client involved in the contract.
     *
     * @return The client involved in the contract.
     */
    public Client getClient() {
        return client;
    }
    /**
     * Sets the client involved in the contract.
     *
     * @param client The client involved in the contract.
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * Gets the property involved in the contract.
     *
     * @return The property involved in the contract.
     */
    public Property getProperty() {
        return property;
    }
    /**
     * Sets the property involved in the contract.
     *
     * @param property The property involved in the contract.
     */
    public void setProperty(Property property) {
        this.property = property;
    }
    /**
     * Returns a string representation of the contract.
     *
     * @return A string containing the contract's ID, type, duration, agent, client, and property.
     */
    @Override
    public String toString() {
        return id + "," + type + "," + duration + "," + agent + "," + client + "," + property;
    }
//    @Override
//    public String toString() {
//        return "Contract{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", duration=" + duration + " months"+
//                ", agent=" + agent +
//                ", client=" + client +
//                ", property=" + property +
//                '}';
//    }
}