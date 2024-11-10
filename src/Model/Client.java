package Model;

import java.util.List;

public class Client extends Person implements HasID {
    ClientType client_type;
    private List<Property> seeProperty;
    public Client(Integer id, String name, String email,  Integer phoneNumber, ClientType clientType) {
        super(id, name,phoneNumber,email);
        this.client_type = clientType;
    }

    public enum ClientType {
        BUYER,
        SELLER,
        RENTER,
        INVESTOR
    }

    public List<Property> getSeeProperty() {
        return seeProperty;
    }
    public void setSeeProperty(List<Property> seeProperty) {
        this.seeProperty = seeProperty;
    }
    public ClientType getClientType() {
        return this.client_type;
    }
    public void setClientType(ClientType clientType) {
        this.client_type = clientType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_type=" + client_type +
                ", id=" + id +
                ", Name='" + Name + '\'' +
                ", Phone_Number=+40" + Phone_Number +
                ", Email='" + Email + '\'' +
                '}';
    }
}

