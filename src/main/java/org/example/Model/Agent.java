package org.example.Model;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an agent in the real estate agency, inheriting from the Person class and implementing the HasID interface.
 */
public class Agent extends Person implements HasID {
    private Integer licenseNumber;
    private List<Property> assignedProperties;
    /**
     * Constructs an Agent object with specified details.
     *
     * @param id            the unique identifier of the agent
     * @param name          the name of the agent
     * @param phoneNumber   the phone number of the agent
     * @param email         the email address of the agent
     * @param licenseNumber the professional license number of the agent
     */
    public Agent(Integer id, String name, Integer phoneNumber,String email, Integer licenseNumber){
        super(id, name, phoneNumber, email);
        if(name == null || email == null || phoneNumber == null || licenseNumber == null){
            throw new IllegalArgumentException("Agent fields cannot be null");
        }
        this.licenseNumber = licenseNumber;
        this.assignedProperties = new ArrayList<>();
    }
    /**
     * Default constructor for the Agent class.
     */
    public Agent(){
        this.assignedProperties = new ArrayList<>();
    }
    /**
     * Retrieves the license number of the agent.
     *
     * @return the license number of the agent
     */
    public Integer getLicenseNumber() {
        return licenseNumber;
    }
    /**
     * Sets the license number of the agent.
     *
     * @param licenseNumber the license number of the agent
     */
    public void setLicenseNumber(Integer licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    /**
     * Retrieves the list of properties assigned to the agent.
     *
     * @return the list of properties assigned to the agent
     */
    public List<Property> getAssignedProperties() {
        return assignedProperties;
    }
    /**
     * Sets the list of properties assigned to the agent.
     *
     * @param assignedProperties the list of properties assigned to the agent
     */
    public void setAssignedProperties(List<Property> assignedProperties) {
        this.assignedProperties = assignedProperties;
    }
    /**
     * Converts the agent's details into a CSV (Comma-Separated Values) format.
     * The format includes ID, name, phone number, email, and license number.
     *
     * @return a string representation of the agent in CSV format
     */
    @Override
    public String toCsv() {
        return id + "," + name + "," + phoneNumber + "," + email + "," + licenseNumber;
    }
    /**
     * Converts the agent's details into a string representation.
     * The format includes ID, name, phone number, email, and license number.
     *
     * @return a string representation of the agent
     */
    @Override
    public String toString() {
        return id + "," + name + "," + phoneNumber + "," + email + "," + licenseNumber;
    }
}
