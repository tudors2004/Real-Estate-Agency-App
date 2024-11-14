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
        //TODO: Trebuie sa scapam de toate afisarile din Service si sa le mutam in UI!!!!!!
        IRepository<Agent> agentRepository = new FileRepository<>("data/agents.txt");
        IRepository<Property> propertyRepository = new FileRepository<>("data/properties.txt");
        IRepository<Contract> contractRepository = new FileRepository<>("data/contracts.txt");
        IRepository<Appointment> appointmentRepository = new FileRepository<>("data/appointments.txt");
        IRepository<Client> clientRepository = new FileRepository<>("data/clients.txt");
        IRepository<Review> reviewRepository = new FileRepository<>("data/reviews.txt");
        IRepository<ClientPreferences> clientPreferencesRepository = new FileRepository<>("data/clientPreferences.txt");
//        IRepository<Agent> agentRepository = new InMemoryRepository<>();
//        IRepository<Property> propertyRepository = new InMemoryRepository<>();
//        IRepository<Contract> contractRepository = new InMemoryRepository<>();
//        IRepository<Appointment> appointmentRepository = new InMemoryRepository<>();
//        IRepository<Client> clientRepository = new InMemoryRepository<>();
//        IRepository<Review> reviewRepository = new InMemoryRepository<>();
//        IRepository<ClientPreferences> clientPreferencesRepository = new InMemoryRepository<>();
        Service service = new Service(agentRepository, propertyRepository, contractRepository, appointmentRepository, clientRepository, reviewRepository,clientPreferencesRepository);
        Controller controller = new Controller(service);
        UI ui = new UI(controller);
        ui.run();
    }
}

