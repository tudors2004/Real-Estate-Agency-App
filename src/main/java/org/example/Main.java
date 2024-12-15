package org.example;
import org.example.UI.*;
import org.example.Controller.*;
import org.example.Model.*;
import org.example.Repository.*;
import org.example.Service.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The Main class serves as the entry point for the application, initializing
 * the repositories, services, controller, and user interface components.
 */
public class Main {
    public static void main(String[] args) {
        //TODO: De pus try catch la toate functiile unde am doar throw!
        System.out.println("===== Enter the number correlated with the desired saving method =====");
        System.out.println("1. InMemoryRepository");
        System.out.println("2. FileRepository");
        System.out.println("3. DatabaseRepository");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            try {
                System.out.print("Your choice (1/2/3): ");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        IRepository<Agent> agentRepository;
        IRepository<Property> propertyRepository;
        IRepository<Contract> contractRepository;
        IRepository<Appointment> appointmentRepository;
        IRepository<Client> clientRepository;
        IRepository<Review> reviewRepository;
        IRepository<ClientPreferences> clientPreferencesRepository;

        switch (choice) {
            case 1 -> {
                agentRepository = new InMemoryRepository<>();
                propertyRepository = new InMemoryRepository<>();
                contractRepository = new InMemoryRepository<>();
                appointmentRepository = new InMemoryRepository<>();
                clientRepository = new InMemoryRepository<>();
                reviewRepository = new InMemoryRepository<>();
                clientPreferencesRepository = new InMemoryRepository<>();
            }
            case 2 -> {
                agentRepository = new FileRepository<>("data/agents.txt", Agent.class);
                propertyRepository = new FileRepository<>("data/properties.txt", Property.class);
                contractRepository = new FileRepository<>("data/contracts.txt", Contract.class);
                appointmentRepository = new FileRepository<>("data/appointments.txt", Appointment.class);
                clientRepository = new FileRepository<>("data/clients.txt", Client.class);
                reviewRepository = new FileRepository<>("data/reviews.txt", Review.class);
                clientPreferencesRepository = new FileRepository<>("data/clientPreferences.txt", ClientPreferences.class);
            }
            case 3 -> {
                agentRepository = new DBRepository<>(Agent.class);
                propertyRepository = new DBRepository<>(Property.class);
                contractRepository = new DBRepository<>(Contract.class);
                appointmentRepository = new DBRepository<>(Appointment.class);
                clientRepository = new DBRepository<>(Client.class);
                reviewRepository = new DBRepository<>(Review.class);
                clientPreferencesRepository = new DBRepository<>(ClientPreferences.class);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        Service service = new Service(agentRepository, propertyRepository, contractRepository, appointmentRepository, clientRepository, reviewRepository,clientPreferencesRepository);
        Controller controller = new Controller(service);
        UI ui = new UI(controller);
        ui.run();
    }
}