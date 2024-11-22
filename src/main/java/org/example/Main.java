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
        IRepository<Agent> agentRepository = new FileRepository<>("data/agents.txt", Agent.class);
        IRepository<Property> propertyRepository = new FileRepository<>("data/properties.txt", Property.class);
        IRepository<Contract> contractRepository = new FileRepository<>("data/contracts.txt", Contract.class);
        IRepository<Appointment> appointmentRepository = new FileRepository<>("data/appointments.txt", Appointment.class);
        IRepository<Client> clientRepository = new FileRepository<>("data/clients.txt", Client.class);
        IRepository<Review> reviewRepository = new FileRepository<>("data/reviews.txt", Review.class);
        IRepository<ClientPreferences> clientPreferencesRepository = new FileRepository<>("data/clientPreferences.txt", ClientPreferences.class);
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

        Agent agent1=new Agent(1,"Mihai",567983,"pmihai@hash.com",8743223);
        Agent agent2=new Agent(2,"Andrei",873242,"andreip@hash.com",87431223);
        Agent agent3=new Agent(3,"Alex",567421,"alex@hash.com",8755223);
        Agent agent4=new Agent(4,"Ion",1413134,"ion@hash.com",8721223);
        Client client1=new Client(1,"Alexandru",8731531,"alexandru@yahoo.com", Client.ClientType.BUYER);
        Client client2=new Client(2,"Mihnea",3243143,"mihnea@yahoo.com", Client.ClientType.INVESTOR);
        Client client3=new Client(3,"George",2313123,"george@yahoo.com", Client.ClientType.SELLER);
        Property property1=new Property(1, Property.PropertyType.RESIDENTIAL , "Str.Ciresilor",43350,2004,312,
                Property.PropertyStatus.AVAILABLE,412.2,"There is this very nice residency.",2);


        agentRepository.create(agent1);
        agentRepository.create(agent2);
        agentRepository.create(agent3);
        agentRepository.create(agent4);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);
        propertyRepository.create(property1);


        ui.run();
    }
}