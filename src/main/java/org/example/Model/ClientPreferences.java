package org.example.Model;
import org.example.Model.Property.*;
import java.util.*;
/**
 * Represents the preferences of a client in the real estate agency, extending the Client class.
 */
public class ClientPreferences extends Client {
    private double budget;
    private String location;
    private PropertyType preferredType;
    private PropertyStatus preferredStatus;
    private Integer year;
    private double size;
    private Integer rooms;
    /**
     * Constructs a ClientPreferences object with the specified client information and preferences.
     *
     * @param client          the {@link Client} object containing the client's basic information
     * @param budget          the client's budget for the property
     * @param location        the preferred location for the property
     * @param preferredType   the preferred type of the property
     * @param preferredStatus the preferred status of the property
     * @param year            the maximum construction year of the property
     * @param size            the preferred size of the property
     * @param rooms           the preferred number of rooms in the property
     * @throws IllegalArgumentException if the client ID is null
     */
    public ClientPreferences(Client client, double budget, String location,
                             PropertyType preferredType, PropertyStatus preferredStatus, int year, double size, int rooms) {
        super(client.getId(), client.getName(), client.getPhoneNumber(), client.getEmail(), client.getClientType());
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.budget = budget;
        this.location = location;
        this.preferredType = preferredType;
        this.preferredStatus = preferredStatus;
        this.year = year;
        this.size = size;
        this.rooms = rooms;
    }
    /**
     * Default constructor. Initializes the client's preferences to default values.
     */
    public ClientPreferences(){}
    /**
     * Gets the client's maximum budget.
     * @return The client's maximum budget.
     */
    public double getBudget() {
        return budget;
    }
    /**
     * Sets the client's maximum budget.
     * @param budget The client's maximum budget.
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }
    /**
     * Gets the client's preferred location.
     * @return The client's preferred location.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Sets the client's preferred location.
     * @param location The client's preferred location.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Gets the client's preferred property type.
     * @return The client's preferred property type.
     */
    public PropertyType getPreferredType() {
        return preferredType;
    }
    /**
     * Sets the client's preferred property type.
     * @param preferredType The client's preferred property type.
     */
    public void setPreferredType(PropertyType preferredType) {
        this.preferredType = preferredType;
    }
    /**
     * Gets the client's preferred property status.
     * @return The client's preferred property status.
     */
    public PropertyStatus getPreferredStatus() {
        return preferredStatus;
    }
    /**
     * Sets the client's preferred property status.
     * @param preferredStatus The client's preferred property status.
     */
    public void setPreferredStatus(PropertyStatus preferredStatus) {
        this.preferredStatus = preferredStatus;
    }
    /**
     * Gets the maximum construction year of the property preferred by the client.
     * @return The maximum construction year of the property preferred by the client.
     */
    public Integer getYear() {
        return year;
    }
    /**
     * Sets the maximum construction year of the property preferred by the client.
     * @param year The maximum construction year of the property preferred by the client.
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * Gets the preferred size of the property.
     * @return The preferred size of the property.
     */
    public double getSize() {
        return size;
    }
    /**
     * Sets the preferred size of the property.
     * @param size The preferred size of the property.
     */
    public void setSize(double size) {
        this.size = size;
    }
    /**
     * Gets the preferred number of rooms in the property.
     * @return The preferred number of rooms in the property.
     */
    public Integer getRooms() {
        return rooms;
    }
    /**
     * Sets the preferred number of rooms in the property.
     * @param rooms The preferred number of rooms in the property.
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    /**
     * Checks if a given property matches the client's preferences.
     *
     * @param property The property to be compared.
     * @return True if the property matches all preferences, false otherwise.
     */
    public boolean matchesPreferences(Property property) {
        return property.getLocation().toLowerCase().contains(location.toLowerCase()) &&
                property.getPrice() <= budget &&
                property.getYear() <= year &&
                property.getStatus() == preferredStatus &&
                property.getType() == preferredType &&
                property.getSize() == size &&
                Objects.equals(property.getRooms(), rooms);
    }
    /**
     * Converts the client's preferences into a CSV (Comma-Separated Values) format.
     * @return a string representation of the client's preferences in CSV format
     */
    @Override
    public String toCsv() {
        return id + "," +
                name + "," +
                phoneNumber + "," +
                email + "," +
                clientType + "," +
                budget + "," +
                location + "," +
                preferredType + "," +
                preferredStatus + "," +
                year + "," +
                size + "," +
                rooms;
    }
    /**
     * Returns a string representation of the client's preferences.
     * @return A string containing the client's budget, location, preferred type, preferred status, year, size, and rooms.
     */
    @Override
    public String toString() {
        return id + "," +
                name + "," +
                phoneNumber + "," +
                email + "," +
                clientType + "," +
                budget + "," +
                location + "," +
                preferredType + "," +
                preferredStatus + "," +
                year + "," +
                size + "," +
                rooms;
    }

}