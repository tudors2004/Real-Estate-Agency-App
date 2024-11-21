package org.example.Model;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a client in the real estate agency, inheriting from the Person class and implementing the HasID interface.
 */
public class Client extends Person implements HasID {
    ClientType clientType;
    private List<Property> seeProperty;

    public Client(Integer id, String name, Integer phoneNumber, String email, ClientType clientType) {
        super(id, name, phoneNumber, email);
        this.clientType = clientType;
    }
    // No-argument constructor
    public Client() {
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

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public List<Property> getSeeProperty() {
        return seeProperty;
    }

    public void setSeeProperty(List<Property> seeProperty) {
        this.seeProperty = seeProperty;
    }

    @Override
    public String toCsv() {
        return id+","+name+","+phoneNumber+","+email+","+clientType;
    }
}
