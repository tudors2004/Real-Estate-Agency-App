package org.example.Model;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    // Enum Definitions
    public enum PropertyType {
        RESIDENTIAL,
        COMMERCIAL,
        INDUSTRIAL,
        SPECIAL
    }

    public enum PropertyStatus {
        AVAILABLE,
        UNDER_CONSTRUCTION,
        RENTED
    }

    // Constructor
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
    public Property(){
        //default constructor
    }
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
