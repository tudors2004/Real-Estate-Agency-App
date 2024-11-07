package Model;

import java.util.ArrayList;
import java.util.List;

public class Agent extends Person implements HasID {
    private Integer License_Number;
    private List<Property> assigned_Properties;

    public Agent(Integer id, Integer License_Number,String Name,  String Email, Integer Phone_Number) {
        super(id, Name,Phone_Number,Email);
        this.License_Number = License_Number;
        this.assigned_Properties = new ArrayList<>();
    }

    public Integer getLicense_Numb() {
        return License_Number;
    }

    public void setLicense_Numb(Integer License_Number) {
        this.License_Number = License_Number;
    }

    public List<Property> getAssignedProperty() {
        return this.assigned_Properties;
    }

    public void setAssignedProperty(List<Property> assigned_Properties) {
        this.assigned_Properties = assigned_Properties;
    }

    public void printAssignedProperties() {
        for (Property property : assigned_Properties) {
            System.out.println(property);
        }
    }

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
