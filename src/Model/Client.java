package Model;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements HasID {
    private String clientType;
    private List<Property> preferences;

    public Client(Integer id, String Name, String Email, Integer Phone_Number, String clientType) {
        super(id, Name, Phone_Number, Email);
        this.clientType = clientType;
        this.preferences = new ArrayList<>();
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public List<Property> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Property> preferences) {
        this.preferences = preferences;
    }
}
