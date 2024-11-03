package Controller;
import Service.Service;
import Model.*;
import java.util.List;
public class Controller {
    private final Service service;
    public Controller(Service service) {
        this.service = service;
    }
    public void addProperty(Property property) {
        service.addProperty(property);
    }
    public void deleteProperty(int id) {
        service.deleteProperty(id);
    }
    public void updateProperty(Property property) {service.updateProperty(property);}
}
