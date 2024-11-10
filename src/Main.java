import UI.*;
import Controller.*;
import Model.*;
import Repository.*;
import Service.*;
/**
 * The Main class serves as the entry point for the application, initializing
 * the repositories, services, controller, and user interface components.
 */
public class Main {
    public static void main(String[] args) {
        IRepository<Agent> agentRepository = new InMemoryRepository<>();
        IRepository<Property> propertyRepository = new InMemoryRepository<>();
        IRepository<Contract> contractRepository = new InMemoryRepository<>();
        IRepository<Appointment> appointmentRepository = new InMemoryRepository<>();
        IRepository<Client> clientRepository = new InMemoryRepository<>();
        IRepository<Review> reviewRepository = new InMemoryRepository<>();
        IRepository<ClientPreferences> clientPreferencesRepository = new InMemoryRepository<>();
        Service service = new Service(agentRepository, propertyRepository, contractRepository, appointmentRepository, clientRepository, reviewRepository,clientPreferencesRepository);
        Controller controller = new Controller(service);
        UI ui = new UI(controller);
        ui.run();
    }
}

