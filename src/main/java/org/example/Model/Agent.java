package org.example.Model;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an agent in the real estate agency, inheriting from the Person class and implementing the HasID interface.
 */
public class Agent extends Person implements HasID {
    private Integer licenseNumber;
    private List<Property> assignedProperties;

    public Agent(Integer id, String name, Integer phoneNumber,String email, Integer licenseNumber){
        super(id, name, phoneNumber, email);
        this.licenseNumber = licenseNumber;
    }
    public Agent(){
        //default constructor
    }
    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Integer licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public List<Property> getAssignedProperties() {
        return assignedProperties;
    }

    public void setAssignedProperties(List<Property> assignedProperties) {
        this.assignedProperties = assignedProperties;
    }

    @Override
    public String toCsv() {
        return id + "," + name + "," + phoneNumber + "," + email + "," + licenseNumber;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + phoneNumber + "," + email + "," + licenseNumber;
    }
}
