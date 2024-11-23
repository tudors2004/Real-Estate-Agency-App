package org.example.Model;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a client in the real estate agency, inheriting from the Person class and implementing the HasID interface.
 */
public class Client extends Person implements HasID {
    ClientType clientType;
    private List<Property> seeProperty;
    /**
     * Constructs a Client object with specified details.
     *
     * @param id          the unique identifier of the client
     * @param name        the name of the client
     * @param phoneNumber the phone number of the client
     * @param email       the email address of the client
     * @param clientType  the type of the client
     */
    public Client(Integer id, String name, Integer phoneNumber, String email, ClientType clientType) {
        super(id, name, phoneNumber, email);
        this.clientType = clientType;
    }
    /**
     * Default constructor for the Client class.
     */
    public Client() {}
    /**
     * Enum representing the type of the client.
     */
    public enum ClientType {
        BUYER,
        SELLER,
        RENTER,
        INVESTOR
    }
    /**
     * Retrieves the type of the client.
     *
     * @return the type of the client
     */
    public ClientType getClientType() {
        return clientType;
    }
    /**
     * Sets the type of the client.
     *
     * @param clientType the type of the client
     */
    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
    /**
     * Retrieves the list of properties the client has seen.
     *
     * @return the list of properties the client has seen
     */
    public List<Property> getSeeProperty() {
        return seeProperty;
    }
    /**
     * Sets the list of properties the client has seen.
     *
     * @param seeProperty the list of properties the client has seen
     */
    public void setSeeProperty(List<Property> seeProperty) {
        this.seeProperty = seeProperty;
    }

    /**
     * Converts the client's details into a CSV (Comma-Separated Values) format.
     * The format includes ID, name, phone number, email, and client type.
     *
     * @return a string representation of the client in CSV format
     */
    @Override
    public String toCsv() {
        return id+","+name+","+phoneNumber+","+email+","+clientType;
    }
    /**
     * Converts the client's details into a string representation.
     * The format includes ID, name, phone number, email, and client type.
     *
     * @return a string representation of the client
     */
    @Override
    public String toString() {
        return id+","+name+","+phoneNumber+","+email+","+clientType;
    }
}
