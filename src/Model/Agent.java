package Model;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents an agent in the real estate agency, inheriting from the Person class and implementing the HasID interface.
 */
public class Agent extends Person implements HasID {
    private Integer License_Number;
    private List<Property> assigned_Properties;
    /**
     * Constructs an Agent object with the specified ID, license number, name, email, and phone number.
     *
     * @param id              The unique identifier of the agent.
     * @param License_Number The license number of the agent.
     * @param Name           The name of the agent.
     * @param Email          The email address of the agent.
     * @param Phone_Number   The phone number of the agent.
     */
    public Agent(Integer id, Integer License_Number,String Name,  String Email, Integer Phone_Number) {
        super(id, Name,Phone_Number,Email);
        this.License_Number = License_Number;
        this.assigned_Properties = new ArrayList<>();
    }
    /**
     * Gets the license number of the agent.
     *
     * @return The license number of the agent.
     */
    public Integer getLicense_Numb() {
        return License_Number;
    }
    /**
     * Sets the license number of the agent.
     *
     * @param License_Number The license number of the agent.
     */
    public void setLicense_Numb(Integer License_Number) {
        this.License_Number = License_Number;
    }
    /**
     * Gets the list of properties assigned to the agent.
     *
     * @return The list of properties assigned to the agent.
     */
    public List<Property> getAssignedProperty() {
        return this.assigned_Properties;
    }
    /**
     * Sets the list of properties assigned to the agent.
     *
     * @param assigned_Properties The list of properties assigned to the agent.
     */
    public void setAssignedProperty(List<Property> assigned_Properties) {
        this.assigned_Properties = assigned_Properties;
    }
    /**
     * Prints the details of all properties assigned to the agent.
     */
    public void printAssignedProperties() {
        for (Property property : assigned_Properties) {
            System.out.println(property);
        }
    }
    /**
     * Returns a string representation of the agent.
     *
     * @return A string containing the agent's license number, ID, name, phone number, and email.
     */
    @Override
    public String toString() {
        return "Agent{" +
                "License_Number=" + License_Number +
                ", id=" + id +
                ", Name='" + Name + '\'' +
                ", Phone_Number=+40" + Phone_Number +
                ", Email='" + Email + '\'' +
                '}';
    }
}
