import Parsers.*;
import UI.*;
import Controller.*;
import Model.*;
import Repository.*;
import Service.*;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The Main class serves as the entry point for the application, initializing
 * the repositories, services, controller, and user interface components.
 */
public class Main {
    public static void main(String[] args) {
        //TODO: Trebuie sa scapam de toate afisarile din Service si sa le mutam in UI!!!!!!
        IRepository<Agent> agentRepository = new FileRepository<>("data/agent.txt",new AgentParser());
        IRepository<Property> propertyRepository = new FileRepository<>("data/property.txt",new PropertyParse());
        IRepository<Contract> contractRepository = new FileRepository<>("data/contract.txt",new ContractParse());
        IRepository<Appointment> appointmentRepository = new FileRepository<>("data/appointment.txt",new AppointmentParser());
        IRepository<Client> clientRepository = new FileRepository<>("data/client.txt",new ClientParser());
        IRepository<Review> reviewRepository = new FileRepository<>("data/review.txt",new ReviewParse());
        IRepository<ClientPreferences> clientPreferencesRepository = new FileRepository<>("data/clientpreferences.txt",new ClientPreferencesParse());
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
        Client client1 = new Client(1, "John Doe","johndoe@gmail.com",4567823, Client.ClientType.BUYER);
        Client client2 = new Client(2, "Jane Smith","janesmith@gmail.com",4567823, Client.ClientType.BUYER);
        Client client3=new Client(3,"Mihai Copaciu","mihaicopaciu@gmail.com",4567823, Client.ClientType.BUYER);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);
        ui.run();

    }
}

