package Model;

import  Model.Property.PropertyType;
import Model.Property.PropertyStatus;
import java.util.Objects;
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
     * Gets the number of rooms the client prefers.
     * @return The number of rooms the client prefers.
     */
    public Integer getRooms() {
        return rooms;
    }
    /**
     * Sets the number of rooms the client prefers.
     * @param rooms The number of rooms the client prefers.
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    /**
     * Gets the size of the property the client prefers.
     * @return The size of the property the client prefers.
     */
    public double getSize() {
        return size;
    }
    /**
     * Sets the size of the property the client prefers.
     * @param size The size of the property the client prefers.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Gets the desired year the property was built (or newer).
     * @return The desired year the property was built (or newer).
     */
    public Integer getYear() {
        return year;
    }
    /**
     * Sets the desired year the property was built (or newer).
     * @param year The desired year the property was built (or newer).
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Gets the client's preferred status.
     * @return The client's preferred status.
     */
    public PropertyStatus getPreferredStatus() {
        return preferredStatus;
    }
    /**
     * Sets the client's preferred status.
     * @param preferredStatus The client's preferred status.
     */
    public void setPreferredStatus(PropertyStatus preferredStatus) {
        this.preferredStatus = preferredStatus;
    }
    /**
     * Gets the client's preferred type.
     * @return The client's preferred type.
     */
    public PropertyType getPreferredType() {
        return preferredType;
    }
    /**
     * Sets the client's preferred type.
     * @param preferredType The client's preferred type.
     */
    public void setPreferredType(PropertyType preferredType) {
        this.preferredType = preferredType;
    }

    /**Constructs a ClientPreferences object with the specified client, budget, location, preferred type, preferred status, year, size, and rooms.
     * @param client The existing client object.
     * @param budget The client's maximum budget.
     * @param location The client's preferred location.
     * @param preferredType The client's preferred property type.
     * @param preferredStatus The client's desired property status.
     * @param year The desired year the property was built (or newer).
     * @param size The desired size of the property in square meters.
     * @param rooms The desired number of rooms in the property.
     */
    public ClientPreferences(Client client, double budget, String location, PropertyType preferredType, PropertyStatus preferredStatus, int year, double size, int rooms) {
        super(client.getId(),client.getName(),client.getEmail(), client.getPhone_numb(),client.getClientType());
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
     * Constructs a ClientPreferences object with the specified data and client.
     *
     * @param data An array of strings containing the client's budget, location, preferred type, preferred status, year, size, and rooms.
     * @param client The existing client object.
     */
   public ClientPreferences(String[] data, Client client){
        super(client.getId(),client.getName(),client.getEmail(), client.getPhone_numb(),client.getClientType());
        this.budget = Double.parseDouble(data[0]);
        this.location = data[1];
        this.preferredType = PropertyType.valueOf(data[2]);
        this.preferredStatus = PropertyStatus.valueOf(data[3]);
        this.year = Integer.parseInt(data[4]);
        this.size = Double.parseDouble(data[5]);
        this.rooms = Integer.parseInt(data[6]);
    }
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
     * Returns a string representation of the client's preferences.
     *
     * @return A string containing the client's budget, location, preferred type, preferred status, year, size, and rooms.
     */
    @Override
    public String toString() {
        return budget + "," + location + "," + preferredType + "," + preferredStatus + "," + year + "," + size + "," + rooms + "," + id + "," + Name + "," + Phone_Number + "," + Email;
    }
//    @Override
//    public String toString() {
//        return "ClientPreferences{" +
//                "budget=" + budget +
//                ", location='" + location + '\'' +
//                ", preferredType=" + preferredType +
//                ", preferredStatus=" + preferredStatus +
//                ", year=" + year +
//                ", size=" + size + " m^2" +
//                ", rooms=" + rooms +
//                ", client_type=" + client_type +
//                ", id=" + id +
//                ", Name='" + Name + '\'' +
//                ", Phone_Number=" + Phone_Number +
//                ", Email='" + Email + '\'' +
//                '}';
//    }
}
