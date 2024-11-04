package Model;

public class Client extends Person implements HasID {
    ClientType client_type;
    Preferences preferences;
    public Client(Integer id, String name, String email, Integer phoneNumber, ClientType clientType, Preferences preferences) {
        super(id, name,phoneNumber,email);
        this.client_type = clientType;
        this.preferences = preferences;
    }
    public enum ClientType {
        BUYER,
        SELLER,
        RENTER;
    }


    public static class Preferences {
        private double budget;
        private String location;


        public Preferences(double budget, String location) {
            this.budget = budget;
            this.location = location;
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
    }

    public ClientType getClientType() {
        return this.client_type;
    }

    public void setClientType(ClientType clientType) {
        this.client_type = clientType;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

}

