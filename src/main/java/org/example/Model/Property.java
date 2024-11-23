package org.example.Model;

import java.util.List;


public class Property implements HasID {
    private Integer id;
    private PropertyType type;
    private String location;
    private double price;
    private Integer year;
    private Integer rooms;
    private PropertyStatus status;
    private double size;
    private String description;
    private Integer agentID;
    private List<Client> seenByClient;
    /**
     * Enum representing the type of the property.
     */
    public enum PropertyType {
        RESIDENTIAL,
        COMMERCIAL,
        INDUSTRIAL,
        SPECIAL
    }
    /**
     * Enum representing the status of the property.
     */
    public enum PropertyStatus {
        AVAILABLE,
        UNDER_CONSTRUCTION,
        RENTED
    }
    /**
     * Constructs a Property object with the specified details.
     *
     * @param id          the unique identifier of the property
     * @param type        the type of the property
     * @param location    the location of the property
     * @param price       the price of the property
     * @param year        the construction year of the property
     * @param rooms       the number of rooms in the property
     * @param status      the status of the property
     * @param size        the size of the property
     * @param description the description of the property
     * @param agentID     the unique identifier of the agent responsible for the property
     */
    public Property(Integer id, PropertyType type, String location, double price, Integer year,
                    Integer rooms, PropertyStatus status, double size, String description,
                    Integer agentID) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.price = price;
        this.year = year;
        this.rooms = rooms;
        this.status = status;
        this.size = size;
        this.description = description;
        this.agentID = agentID;
    }
    /**
     * Default constructor for the Property class.
     */
    public Property(){}
    /**
     * Gets the unique identifier of the property.
     *
     * @return The unique identifier of the property.
     */
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public PropertyStatus getStatus() {
        return status;
    }

    public void setStatus(PropertyStatus status) {
        this.status = status;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }

    public List<Client> getSeenByClient() {
        return seenByClient;
    }

    public void setSeenByClient(List<Client> seenByClient) {
        this.seenByClient = seenByClient;
    }

    @Override
    public String toCsv() {
        return id + "," +
                type + "," +
                location + "," +
                price + "," +
                year + "," +
                rooms + "," +
                status + "," +
                size + "," +
                description + "," +
                agentID;
    }

    @Override
    public String toString() {
        return id + "," +
                type + "," +
                location + "," +
                price + "," +
                year + "," +
                rooms + "," +
                status + "," +
                size + "," +
                description + "," +
                agentID;
    }

}
