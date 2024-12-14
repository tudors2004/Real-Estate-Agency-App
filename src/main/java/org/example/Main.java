package org.example;
import org.example.UI.*;
import org.example.Controller.*;
import org.example.Model.*;
import org.example.Repository.*;
import org.example.Service.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

/**
 * The Main class serves as the entry point for the application, initializing
 * the repositories, services, controller, and user interface components.
 */
public class Main {
    public static void main(String[] args) {
        //TODO: De pus try catch la toate functiile unde am doar throw!
        IRepository<Agent> agentRepository = new DBRepository<>(Agent.class);
        IRepository<Property> propertyRepository = new DBRepository<>(Property.class);
        IRepository<Contract> contractRepository = new DBRepository<>(Contract.class);
        IRepository<Appointment> appointmentRepository = new DBRepository<>(Appointment.class);
        IRepository<Client> clientRepository = new DBRepository<>(Client.class);
        IRepository<Review> reviewRepository = new DBRepository<>(Review.class);
        IRepository<ClientPreferences> clientPreferencesRepository = new DBRepository<>(ClientPreferences.class);
//        IRepository<Agent> agentRepository = new FileRepository<>("data/agents.txt", Agent.class);
//        IRepository<Property> propertyRepository = new FileRepository<>("data/properties.txt", Property.class);
//        IRepository<Contract> contractRepository = new FileRepository<>("data/contracts.txt", Contract.class);
//        IRepository<Appointment> appointmentRepository = new FileRepository<>("data/appointments.txt", Appointment.class);
//        IRepository<Client> clientRepository = new FileRepository<>("data/clients.txt", Client.class);
//        IRepository<Review> reviewRepository = new FileRepository<>("data/reviews.txt", Review.class);
//        IRepository<ClientPreferences> clientPreferencesRepository = new FileRepository<>("data/clientPreferences.txt", ClientPreferences.class);
//        IRepository<Agent> agentRepository = new InMemoryRepository<>();
//        IRepository<Property> propertyRepository = new InMemoryRepository<>();
//        IRepository<Contract> contractRepository = new InMemoryRepository<>();
//        IRepository<Appointment> appointmentRepository = new InMemoryRepository<>();
//        IRepository<Client> clientRepository = new InMemoryRepository<>();
//        IRepository<Review> reviewRepository = new InMemoryRepository<>();
//        IRepository<ClientPreferences> clientPreferencesRepository = new InMemoryRepository<>();
        BigDecimal dbPrice=new BigDecimal("123.45");
        double price=dbPrice.doubleValue();
        Service service = new Service(agentRepository, propertyRepository, contractRepository, appointmentRepository, clientRepository, reviewRepository,clientPreferencesRepository);
        Controller controller = new Controller(service);
        UI ui = new UI(controller);
        Agent agent1=new Agent(1,"Mihai",43141343,"mihaipruneanu@gmail.com",12);
        Client client1=new Client(1,"Andrei",4143141,"andreipruneanu@gmail.com", Client.ClientType.BUYER);
        Property property1=new Property(1, Property.PropertyType.COMMERCIAL,"Cluj,Romania",123.45,2021,3, Property.PropertyStatus.AVAILABLE,65,"Very comfy",1);
        Appointment appointment1=new Appointment(1, Date.valueOf("2024-12-14"),1,1,1);
        agentRepository.create(agent1);
        clientRepository.create(client1);
        propertyRepository.create(property1);
        appointmentRepository.create(appointment1);
//        agentRepository.delete(1);
//        clientRepository.delete(1);
//        propertyRepository.delete(1);
//        appointmentRepository.delete(1);
        ui.run();
    }
}