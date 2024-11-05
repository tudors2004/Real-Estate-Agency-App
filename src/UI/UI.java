package UI;
import Controller.Controller;
import Model.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class UI {
    Scanner scanner = new Scanner(System.in);
    private final Controller controller;
    public UI(Controller controller) {
        this.controller = controller;
    }
    public void run() {
        while(true){
            System.out.println("---- Real Estate Agency Management ----");
            System.out.println("1. Manage Properties");
            System.out.println("2. Manage Clients");
            System.out.println("3. Manage Agents");
            System.out.println("4. Manage Contracts");
            System.out.println("5. Manage Reviews");
            System.out.println("6. Manage Appointments");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> manageProperties();
                    case 2 -> manageClients();
                    case 3 -> manageAgents();
                    case 4 -> manageContracts();
                    case 5 -> manageReviews();
                    case 6 -> manageAppointments();
                    case 0 -> {
                        System.out.println("Exiting application.");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again with a number between 0 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 6 :)");
                scanner.nextLine();
            }
        }
    }

    private void manageProperties() {
        while (true) {
            System.out.println("\n--- Manage Properties ---");
            System.out.println("1. Add Property");
            System.out.println("2. Update Property");
            System.out.println("3. Delete Property");
            System.out.println("4. View Property by ID");
            System.out.println("5. View All Properties");
            System.out.println("6. View unvisited properties");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addProperty();
                case 2 -> updateProperty();
                case 3 -> deleteProperty();
                case 4 -> viewPropertyById();
                case 5 -> viewAllProperties();
                case 6 -> viewUnvisitedProperties();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void manageClients() {
        while (true) {
            System.out.println("\n--- Manage Clients ---");
            System.out.println("1. Add Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. View Client by ID");
            System.out.println("5. View All Clients");
            System.out.println("6. Recommend Properties For Client");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addClient();
                case 2 -> updateClient();
                case 3 -> deleteClient();
                case 4 -> viewClientById();
                case 5 -> viewAllClients();
                case 6 -> recommendPropertiesForClient();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private void manageAgents() {
        while (true) {
            System.out.println("\n--- Manage Agents ---");
            System.out.println("1. Add Agent");
            System.out.println("2. Update Agent");
            System.out.println("3. Delete Agent");
            System.out.println("4. View Agent by ID");
            System.out.println("5. View All Agents");
            System.out.println("6. Analyze Agent Performance");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addAgent();
                case 2 -> updateAgent();
                case 3 -> deleteAgent();
                case 4 -> viewAgentById();
                case 5 -> viewAllAgents();
                case 6 -> analyzeAgentPerformance();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private void manageContracts() {
        while (true) {
            System.out.println("\n--- Manage Contracts ---");
            System.out.println("1. Add Contract");
            System.out.println("2. Update Contract");
            System.out.println("3. Delete Contract");
            System.out.println("4. View Contract by ID");
            System.out.println("5. View All Contracts");
            System.out.println("6. Link Property and Client (Create Contract)");
            System.out.println("7. Generate Monthly Activity Report");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addContract();
                case 2 -> updateContract();
                case 3 -> deleteContract();
                case 4 -> viewContractById();
                case 5 -> viewAllContracts();
                case 6 -> linkPropertyAndClient();
                case 7 -> generateMonthlyActivityReport();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void manageReviews() {
        while (true) {
            System.out.println("\n--- Manage Reviews ---");
            System.out.println("1. Add Review");
            System.out.println("2. Delete Review");
            System.out.println("3. View Reviews by Property");
            System.out.println("4. View All Reviews");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addReview();
                case 2 -> deleteReview();
                case 3 -> viewReviewsByProperty();
                case 4 -> viewAllReviews();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void manageAppointments() {
        while (true) {
            System.out.println("\n--- Manage Appointments ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. Update Appointment");
            System.out.println("3. Delete Appointment");
            System.out.println("4. View Appointment by ID");
            System.out.println("5. View All Appointments");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addAppointment();
                case 2 -> updateAppointment();
                case 3 -> deleteAppointment();
                case 4 -> viewAppointmentById();
                case 5 -> viewAllAppointments();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addProperty() {
        System.out.print("Enter property ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property type: ");
        String type = scanner.nextLine();
        System.out.print("Enter property address: ");
        String address = scanner.nextLine();
        System.out.print("Enter property price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter property year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter number of rooms: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property status: ");
        String status = scanner.nextLine();
        System.out.print("Enter property size: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property description: ");
        String description = scanner.nextLine();
        System.out.print("Enter associated agent ID: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        Agent associatedAgent = controller.viewAgentById(agentId);
        Property property = new Property(id, type, address, price, year, rooms, status, size, description, associatedAgent);
        controller.addProperty(property);
        System.out.println("Property added successfully.");
    }

    private void updateProperty() {
        System.out.print("Enter property ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property type: ");
        String type = scanner.nextLine();
        System.out.print("Enter new property address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new property price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter new property year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new number of rooms: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property status: ");
        String status = scanner.nextLine();
        System.out.print("Enter new property size: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new associated agent ID: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        Agent associatedAgent = controller.viewAgentById(agentId);
        Property property = new Property(id, type, address, price, year, rooms, status, size, description, associatedAgent);
        controller.updateProperty(property);
        System.out.println("Property updated successfully.");
    }

    private void deleteProperty() {
        System.out.print("Enter property ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteProperty(id);
        System.out.println("Property deleted successfully.");
    }

    private void viewPropertyById() {
        System.out.print("Enter property ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Property property = controller.viewPropertyById(id);
        System.out.println(property);
    }

    private void viewAllProperties() {
        List<Property> properties = controller.viewAllProperties();
        for (Property property : properties) {
            System.out.println(property);
        }
    }

    private void viewUnvisitedProperties() {
        //TODO: Implement this method
    }

    private void addClient() {
        System.out.print("Enter client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client email: ");
        String email = scanner.nextLine();
        System.out.print("Enter client phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client type: ");
        String clientType = scanner.nextLine();
        //TODO: Client Preferences
//        Client client = new Client(id, name, email, phoneNumber, clientType);
//        controller.addClient(client);
        System.out.println("Client added successfully.");
    }

    private void updateClient() {
        System.out.print("Enter client ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new client email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new client phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new client type: ");
        String clientType = scanner.nextLine();
        //TODO: Client Preferences
//        Client client = new Client(id, name, email, phoneNumber, clientType);
//        controller.updateClient(client);
        System.out.println("Client updated successfully.");
    }

    private void deleteClient() {
        System.out.print("Enter client ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteClient(id);
        System.out.println("Client deleted successfully.");
    }

    private void viewClientById() {
        System.out.print("Enter client ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Client client = controller.viewClientById(id);
        System.out.println(client);
    }

    private void viewAllClients() {
        List<Client> clients = controller.viewAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void recommendPropertiesForClient() {
        //TODO: Implement this method
    }

    private void addAgent() {
        System.out.print("Enter agent ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter agent license number: ");
        int licenseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter agent name: ");
        String name = scanner.nextLine();
        System.out.print("Enter agent email: ");
        String email = scanner.nextLine();
        System.out.print("Enter agent phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        Agent agent = new Agent(id, licenseNumber, name, email, phoneNumber);
        controller.addAgent(agent);
        System.out.println("Agent added successfully.");
    }

    private void updateAgent() {
        System.out.print("Enter agent ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new agent license number: ");
        int licenseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new agent name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new agent email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new agent phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        Agent agent = new Agent(id, licenseNumber, name, email, phoneNumber);
        controller.updateAgent(agent);
        System.out.println("Agent updated successfully.");
    }

    private void deleteAgent() {
        System.out.print("Enter agent ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteAgent(id);
        System.out.println("Agent deleted successfully.");
    }

    private void viewAgentById() {
        System.out.print("Enter agent ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Agent agent = controller.viewAgentById(id);
        System.out.println(agent);
    }

    private void viewAllAgents() {
        List<Agent> agents = controller.viewAllAgents();
        for (Agent agent : agents) {
            System.out.println(agent);
        }
    }

    private void analyzeAgentPerformance() {
        //TODO: Implement this method
    }

    private void addContract() {
        System.out.print("Enter contract ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter contract type: ");
        String type = scanner.nextLine();
        System.out.print("Enter contract duration (months): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        Contract contract = new Contract(id, type, duration);
        controller.addContract(contract);
        System.out.println("Contract added successfully.");
    }

    private void updateContract() {
        System.out.print("Enter contract ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new contract type: ");
        String type = scanner.nextLine();
        System.out.print("Enter new contract duration (months): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        Contract contract = new Contract(id, type, duration);
        controller.updateContract(contract);
        System.out.println("Contract updated successfully.");
    }

    private void deleteContract() {
        System.out.print("Enter contract ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteContract(id);
        System.out.println("Contract deleted successfully.");
    }

    private void viewContractById() {
        System.out.print("Enter contract ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Contract contract = controller.viewContractById(id);
        System.out.println(contract);
    }

    private void viewAllContracts() {
        List<Contract> contracts = controller.viewAllContracts();
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    private void linkPropertyAndClient() {
        System.out.print("Enter contract ID: ");
        int contractId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property ID: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        controller.linkPropertyAndClient(contractId, propertyId, clientId);
        System.out.println("Property and client linked successfully.");
    }

    private void generateMonthlyActivityReport() {
        //TODO: Implement this method
    }

    private void addReview() {
        System.out.println("Enter review ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter rating: ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        System.out.print("Enter property ID: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        Property property = controller.viewPropertyById(propertyId);
        Client client = controller.viewClientById(clientId);
        Review review = new Review(id, rating, comment, property, client);
        controller.addReview(review);
        System.out.println("Review added successfully.");
    }

    private void deleteReview() {
        System.out.print("Enter review ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteReview(id);
        System.out.println("Review deleted successfully.");
    }

    private void viewReviewsByProperty() {
        System.out.print("Enter property ID to view reviews: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine();
        List<Review> reviews = controller.viewReviewsByProperty(propertyId);
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    private void viewAllReviews() {
        List<Review> reviews = controller.viewAllReviews();
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    private void addAppointment() {
        System.out.print("Enter appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        Date date = Date.valueOf(dateString);
        Appointment appointment = new Appointment(id, date);
        controller.addAppointment(appointment);
        System.out.println("Appointment added successfully.");
    }

    private void updateAppointment() {
        System.out.print("Enter appointment ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new appointment date (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        Date date = Date.valueOf(dateString);
        Appointment appointment = new Appointment(id, date);
        controller.updateAppointment(appointment);
        System.out.println("Appointment updated successfully.");
    }

    private void deleteAppointment() {
        System.out.print("Enter appointment ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.deleteAppointment(id);
        System.out.println("Appointment deleted successfully.");
    }

    private void viewAppointmentById() {
        System.out.print("Enter appointment ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Appointment appointment = controller.viewAppointmentById(id);
        System.out.println(appointment);
    }

    private void viewAllAppointments() {
        List<Appointment> appointments = controller.viewAllAppointments();
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
