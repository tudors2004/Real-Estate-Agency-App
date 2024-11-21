package org.example;
import org.example.UI.*;
import org.example.Controller.*;
import org.example.Model.*;
import org.example.Repository.*;
import org.example.Service.*;
/**
 * The Main class serves as the entry point for the application, initializing
 * the repositories, services, controller, and user interface components.
 */
public class Main {
    public static void main(String[] args) {
        IRepository<Agent> agentRepository = new FileRepository<>("src/main/data/agents.txt", Agent.class);
        IRepository<Property> propertyRepository = new FileRepository<>("src/main/data/properties.txt", Property.class);
        IRepository<Contract> contractRepository = new FileRepository<>("src/main/data/contracts.txt", Contract.class);
        IRepository<Appointment> appointmentRepository = new FileRepository<>("src/main/data/appointments.txt", Appointment.class);
        IRepository<Client> clientRepository = new FileRepository<>("src/main/data/clients.txt", Client.class);
        IRepository<Review> reviewRepository = new FileRepository<>("src/main/data/reviews.txt", Review.class);
        IRepository<ClientPreferences> clientPreferencesRepository = new FileRepository<>("src/main/data/clientPreferences.txt", ClientPreferences.class);
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