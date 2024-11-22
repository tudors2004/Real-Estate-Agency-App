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
    private Boolean matchesPreferences;

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
    public ClientPreferences(){
        //default constructor
    }
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PropertyType getPreferredType() {
        return preferredType;
    }

    public void setPreferredType(PropertyType preferredType) {
        this.preferredType = preferredType;
    }

    public PropertyStatus getPreferredStatus() {
        return preferredStatus;
    }

    public void setPreferredStatus(PropertyStatus preferredStatus) {
        this.preferredStatus = preferredStatus;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public boolean matchesPreferences(Property property) {
        return property.getLocation().toLowerCase().contains(location.toLowerCase()) &&
                property.getPrice() <= budget &&
                property.getYear() <= year &&
                property.getStatus() == preferredStatus &&
                property.getType() == preferredType &&
                property.getSize() == size &&
                Objects.equals(property.getRooms(), rooms);
    }

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