package Model;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a client in the real estate agency, inheriting from the Person class and implementing the HasID interface.
 */
public class Client extends Person implements HasID {
    ClientType client_type;
    private List<Property> seeProperty;
    /**
     * Constructs a Client object with the specified ID, name, email, phone number, and client type.
     *
     * @param id          The unique identifier of the client.
     * @param name        The name of the client.
     * @param email       The email address of the client.
     * @param phoneNumber The phone number of the client.
     * @param clientType  The type of the client.
     */
    public Client(Integer id, String name, String email, Integer phoneNumber, ClientType clientType) {
        super(id, name,phoneNumber,email);
        this.client_type = clientType;
    }
    /**
     * Constructs a Client object with the specified data.
     *
     * @param data The data of the client.
     */
    public Client(String[] data, ClientType clientType) {
        super(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3]);
        this.client_type = clientType;
    }

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
     * Gets the list of properties the client is interested in.
     *
     * @return The list of properties the client is interested in.
     */
    public List<Property> getSeeProperty() {
        return seeProperty;
    }
    /**
     * Sets the list of properties the client is interested in.
     *
     * @param seeProperty The list of properties the client is interested in.
     */
    public void setSeeProperty(List<Property> seeProperty) {
        this.seeProperty = seeProperty;
    }
    /**
     * Gets the type of the client.
     *
     * @return The type of the client.
     */
    public ClientType getClientType() {
        return this.client_type;
    }
    /**
     * Sets the type of the client.
     *
     * @param clientType The type of the client.
     */
    public void setClientType(ClientType clientType) {
        this.client_type = clientType;
    }
    /**
     * Returns a string representation of the client.
     *
     * @return A string containing the client's ID, name, phone number, and email.
     */
    @Override
    public String toString() {
        return id + "," + Name + "," + Phone_Number + "," + Email + "," + client_type;
    }
//    @Override
//    public String toString() {
//        return "Client{" +
//                "client_type=" + client_type +
//                ", id=" + id +
//                ", Name='" + Name + '\'' +
//                ", Phone_Number=+40" + Phone_Number +
//                ", Email='" + Email + '\'' +
//                '}';
//    }
}

