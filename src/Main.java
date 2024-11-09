import UI.*;
import Controller.*;
import Model.*;
import Repository.*;
import Service.*;
public class Main {
    public static void main(String[] args) {
        //TODO: Link property to agent
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

