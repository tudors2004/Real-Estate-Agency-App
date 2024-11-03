package Controller;
import Service.Service;
import Model.*;
import java.util.List;
public class Controller {
    private final Service service = new Service();
    public void addProperty(Property property) {
        service.addProperty(property);
    }
}
