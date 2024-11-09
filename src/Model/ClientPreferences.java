package Model;
import  Model.Property.PropertyType;
import Model.Property.PropertyStatus;

import java.util.List;
import java.util.Objects;

public class ClientPreferences extends Client {
    private double budget;
    private String location;
    private PropertyType preferredType;
    private PropertyStatus preferredStatus;
    private Integer year;
    private double size;
    private Integer rooms;

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public PropertyStatus getPreferredStatus() {
        return preferredStatus;
    }

    public void setPreferredStatus(PropertyStatus preferredStatus) {
        this.preferredStatus = preferredStatus;
    }

    public PropertyType getPreferredType() {
        return preferredType;
    }

    public void setPreferredType(PropertyType preferredType) {
        this.preferredType = preferredType;
    }




    public ClientPreferences(Client client, double budget, String location, PropertyType preferredType, PropertyStatus preferredStatus) {
        super(client.getId(),client.getName(),client.getEmail(), client.getPhone_numb(),client.getClientType());
        this.budget = budget;
        this.location = location;
        this.preferredType = preferredType;
        this.preferredStatus = preferredStatus;

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



    public boolean matchesPreferences(Property property) {
        return property.getLocation().equalsIgnoreCase(location) &&
                property.getPrice() <= budget &&
                property.getYear() <= year &&
                property.getStatus() == preferredStatus &&
                property.getType() == preferredType &&
                property.getSize() == size &&
                Objects.equals(property.getRooms(), rooms);
    }


}
