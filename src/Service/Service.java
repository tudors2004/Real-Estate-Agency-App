package Service;
import Model.*;
import Repository.*;
import java.util.List;

public class Service {
    private final InMemoryRepository<Property> propertyInMemoryRepository = new InMemoryRepository<>();

    public void addProperty(Property property) {
        propertyInMemoryRepository.create(property);
    }

}
