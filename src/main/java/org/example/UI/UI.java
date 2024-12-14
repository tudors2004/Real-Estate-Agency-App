package org.example.UI;
import org.example.Controller.Controller;
import org.example.Model.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;
import org.example.Exceptions.ValidationException;
import org.example.Exceptions.BusinessLogicException;
/**
 * The UI class provides a command-line interface for managing the real estate agency.
 * It interacts with the user to perform various operations such as managing properties, clients, agents, contracts, reviews, and appointments.
 */
@SuppressWarnings("DuplicatedCode")
public class UI {
    Scanner scanner = new Scanner(System.in);
    private final Controller controller;

    /**
     * Constructs a UI object with the specified controller.
     *
     * @param controller The controller to be used for managing the real estate agency operations.
     */
    public UI(Controller controller) {
        this.controller = controller;
    }
    /**
     * Starts the command-line interface for managing the real estate agency.
     */
    public void run() {
        while (true) {
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
                        System.out.println("Exiting application......");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again with a number between 0 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }
    /**
     * Manages the properties in the real estate agency.
     * Provides options to add, update, delete, view properties by ID, view all properties, and view unvisited properties.
     * The method runs in a loop until the user chooses to return to the main menu.
     */
    private void manageProperties() {
        while (true) {
            System.out.println("\n--- Manage Properties ---");
            System.out.println("1. Add Property");
            System.out.println("2. Update Property");
            System.out.println("3. Delete Property");
            System.out.println("4. View Property by ID");
            System.out.println("5. View All Properties");
            System.out.println("6. View Unvisited Properties");
            System.out.println("7. Filter Properties by Price");
            System.out.println("8. Sort Properties by Price");
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
                case 7 -> filterPropertiesByPrice();
                case 8 -> sortPropertiesByPrice();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the clients in the real estate agency.
     * Provides options to add, update, delete, view clients by ID, view all clients, add client preferences, update client preferences, and recommend properties for a client.
     * The method runs in a loop until the user chooses to return to the main menu.
     */
    private void manageClients() {
        while (true) {
            System.out.println("\n--- Manage Clients ---");
            System.out.println("1. Add Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. Add Client Preferences");
            System.out.println("5. Update Client Preferences");
            System.out.println("6. View Client by ID");
            System.out.println("7. View All Clients and Preferences");
            System.out.println("8. Recommend Properties For Client");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addClient();
                case 2 -> updateClient();
                case 3 -> deleteClient();
                case 4 -> addClientPreferences();
                case 5 -> updateClientPreferences();
                case 6 -> viewClientById();
                case 7 -> viewAllClients();
                case 8 -> recommendPropertiesForClient(viewClientById());
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the agents in the real estate agency.
     * Provides options to add, update, delete, view agents by ID, view all agents, view assigned properties, and analyze agent performance.
     * The method runs in a loop until the user chooses to return to the main menu.
     */
    private void manageAgents() {
        while (true) {
            System.out.println("\n--- Manage Agents ---");
            System.out.println("1. Add Agent");
            System.out.println("2. Update Agent");
            System.out.println("3. Delete Agent");
            System.out.println("4. View Agent by ID");
            System.out.println("5. View All Agents");
            System.out.println("6. View Assigned Properties");
            System.out.println("7. Analyze Agent Performance");
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
                case 6 -> viewAssignedProperties();
                case 7 -> analyzeAgentPerformance(viewAgentById());
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the contracts in the real estate agency.
     * Provides options to add, update, delete, view contracts by ID and view all contracts.
     * The method runs in a loop until the user chooses to return to the main menu.
     */
    private void manageContracts() {
        while (true) {
            System.out.println("\n--- Manage Contracts ---");
            System.out.println("1. Add Contract");
            System.out.println("2. Update Contract");
            System.out.println("3. Delete Contract");
            System.out.println("4. View Contract by ID");
            System.out.println("5. View All Contracts");
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
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the reviews in the real estate agency.
     * Provides options to add property reviews, add agent reviews, delete reviews, view reviews by property, and view reviews by agent.
     * The method runs in a loop until the user chooses to return to the main menu.
     */
    private void manageReviews() {
        while (true) {
            System.out.println("\n--- Manage Reviews ---");
            System.out.println("1. Add Property Review");
            System.out.println("2. Add Agent Review");
            System.out.println("3. Delete Review");
            System.out.println("4. View Reviews by Property");
            System.out.println("5. View Reviews by Agent");
            System.out.println("6. Filter Reviews by Rating");
            System.out.println("7. Sort Reviews by Rating");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addPropertyReview();
                case 2 -> addAgentReview();
                case 3 -> deleteReview();
                case 4 -> viewReviewsByProperty();
                case 5 -> viewReviewsByAgent();
                case 6 -> filterReviewByRating();
                case 7 -> sortReviewsByRating();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    /**
     * Manages the appointments in the real estate agency.
     * Provides options to add, update, delete, view appointments by ID, and view all appointments.
     * The method runs in a loop until the user chooses to return to the main menu.
     */
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
    /**
     * Adds a new property to the real estate agency.
     * Prompts the user to enter various details about the property, including ID, type, address, price, year, number of rooms, status, size, description, and associated agent ID.
     * Validates the property type and status, and links the property with the specified agent.
     * If the input is invalid, the method returns to the previous menu.
     */
    public void addProperty(){
        System.out.print("Enter property ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property type (RESIDENTIAL/COMMERCIAL/INDUSTRIAL/SPECIAL): ");
        String str1 = scanner.nextLine().toUpperCase();
        Property.PropertyType type;
        try {
            type = Property.PropertyType.valueOf(str1.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid property type. Please enter RESIDENTIAL/COMMERCIAL/INDUSTRIAL or SPECIAL. Returning to previous menu.");
            return;
        }
        System.out.print("Enter property address: ");
        String address = scanner.nextLine();
        System.out.print("Enter property price (in EUR): ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter property year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter number of rooms: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property status (AVAILABLE/UNDER_CONSTRUCTION/RENTED): ");
        String str2 = scanner.nextLine().toUpperCase();
        Property.PropertyStatus status;
        try {
            status = Property.PropertyStatus.valueOf(str2.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid property status. Please enter AVAILABLE/UNDER_CONSTRUCTION or RENTED. Returning to previous menu.");
            return;
        }
        System.out.print("Enter property size (in meters squared): ");
        double size = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property description: ");
        String description = scanner.nextLine();
        System.out.print("Enter associated agent ID: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        Property property = new Property(id, type, address, price, year, rooms, status, size, description, agentId);
        controller.addProperty(property);
        controller.linkPropertyAndAgent(agentId, id);
        System.out.println("Property added successfully.");
    }
    /**
     * Updates an existing property in the real estate agency.
     * Prompts the user to enter the property ID to update, and then enter the new details about the property, including type, address, price, year, number of rooms, status, size, description, and associated agent ID.
     * Validates the property type and status, and links the property with the specified agent.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void updateProperty() {
        System.out.print("Enter property ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property type (RESIDENTIAL/COMMERCIAL/INDUSTRIAL/SPECIAL): ");
        String str1 = scanner.nextLine().toUpperCase();
        Property.PropertyType type;
        try {
            type = Property.PropertyType.valueOf(str1.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid property type. Please enter RESIDENTIAL/COMMERCIAL/INDUSTRIAL or SPECIAL. Returning to previous menu.");
            return;
        }
        System.out.print("Enter new property address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new property price (in EUR): ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter new property year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new number of rooms: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property status (AVAILABLE/UNDER_CONSTRUCTION/RENTED): ");
        String str2 = scanner.nextLine().toUpperCase();
        Property.PropertyStatus status;
        try {
            status = Property.PropertyStatus.valueOf(str2.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid property status. Please enter AVAILABLE/UNDER_CONSTRUCTION or RENTED. Returning to previous menu.");
            return;
        }
        System.out.print("Enter new property size (in meters squared): ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new associated agent ID: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        Property property = new Property(id, type, address, price, year, rooms, status, size, description, agentId);
        controller.updateProperty(property);
        controller.linkPropertyAndAgent(agentId, id);
        System.out.println("Property updated successfully.");
    }
    /**
     * Deletes an existing property from the real estate agency.
     * Prompts the user to enter the property ID to delete, and then confirms the deletion.
     * If the user confirms the deletion, the property is removed from the database.
     */
    private void deleteProperty() {
        System.out.print("Enter property ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you sure you want to delete this property? (Y/N)");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("N")) {
            System.out.println("Property deletion cancelled. Returning to previous menu.");
        }
        else if(confirmation.equalsIgnoreCase("Y")) {
            controller.deleteProperty(id);
            System.out.println("Property deleted successfully.");
        }
    }
    /**
     * Views a property by its ID.
     * Prompts the user to enter the property ID to view, and then displays the property details.
     * If the property is not found, the method returns to the previous menu.
     */
    private void viewPropertyById() {
        System.out.print("Enter property ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Property property = controller.viewPropertyById(id);
        System.out.println(property);
    }
    /**
     * Views all properties in the real estate agency.
     * Retrieves all properties from the database and displays their details.
     */
    private void viewAllProperties() {
        List<Property> properties = controller.viewAllProperties();
        for (Property property : properties) {
            System.out.println(property);
        }
    }
    /**
     * Views all unvisited properties in the real estate agency.
     * Retrieves all properties that have not been visited by any client and displays their details.
     */
    private void viewUnvisitedProperties() {
        System.out.println("List of the unvisited properties: ");
        controller.getUnvisitedProperties();
    }
    /**
     * Adds a new client to the real estate agency.
     * Prompts the user to enter various details about the client, including ID, name, email, phone number, and type.
     * Validates the client type, and adds the client to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addClient() {
        System.out.print("Enter client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        if(name.isEmpty()){
            System.out.println("Name cannot be empty. Returning to previous menu.");
            return;
        }
        String email;
        while(true) {
            System.out.print("Enter client email (firstlastname@example.com): ");
            email = scanner.nextLine();
            if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")){
                break;
            }
            else{
                System.out.println("Invalid email address. Returning to previous menu.");
                return;
            }
        }
        System.out.print("Enter client phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client type (BUYER/SELLER/RENTER/INVESTOR): ");
        String str1 = scanner.nextLine().toUpperCase();
        Client.ClientType type;
        try {
            type = Client.ClientType.valueOf(str1.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid client type. Please enter BUYER/SELLER/RENTER/INVESTOR. Returning to previous menu.");
            return;
        }
        Client client = new Client(id, name, phoneNumber, email, type);
        controller.addClient(client);
        System.out.println("Client added successfully.");
    }
    /**
     * Adds client preferences to the real estate agency.
     * Prompts the user to enter various details about the client preferences, including budget, location, property type, property status, year of construction, size, and number of rooms.
     * Validates the property type and status, and adds the client preferences to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addClientPreferences(){
        System.out.print("Enter client's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Client client = controller.viewClientById(id);
        if (client == null) {
            System.out.print("Client not found. Returning to previous menu.");
            return;
        }
        System.out.print("Enter client's budget(in EUR): ");
        double budget = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter client's preferred location: ");
        String location = scanner.nextLine();
        System.out.print("Enter client's preferred property type (RESIDENTIAL/COMMERCIAL/INDUSTRIAL/SPECIAL): ");
        String str1 = scanner.nextLine().toUpperCase();
        Property.PropertyType type;
        try {
            type = Property.PropertyType.valueOf(str1.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid property type. Please enter RESIDENTIAL/COMMERCIAL/INDUSTRIAL or SPECIAL. Returning to previous menu.");
            return;
        }
        System.out.print("Enter client's preferred property status (AVAILABLE/UNDER_CONSTRUCTION/RENTED): ");
        String str2 = scanner.nextLine().toUpperCase();
        Property.PropertyStatus status;
        try {
            status = Property.PropertyStatus.valueOf(str2.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid property status. Please enter AVAILABLE/UNDER_CONSTRUCTION or RENTED. Returning to previous menu.");
            return;
        }
        System.out.print("Enter client's preferred year of construction: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client's preferred size (in meters squared): ");
        double size = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter client's preferred number of rooms: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();
        ClientPreferences clientPreferences = new ClientPreferences(client, budget, location, type, status, year, size, rooms);
        controller.addClientPreferences(clientPreferences);
        System.out.println("Client preferences added successfully.");

    }
    /**
     * Updates client preferences in the real estate agency.
     * Prompts the user to enter various details about the client preferences, including budget, location, property type, property status, year of construction, size, and number of rooms.
     * Validates the property type and status, and updates the client preferences in the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void updateClientPreferences(){
        System.out.print("Enter client's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Client client = controller.viewClientById(id);
        if (client == null) {
            System.out.print("Client not found. Returning to previous menu.");
            return;
        }
        System.out.print("Enter client's new budget(in EUR): ");
        double budget = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter client's new preferred location: ");
        String location = scanner.nextLine();
        System.out.print("Enter client's new preferred property type (RESIDENTIAL/COMMERCIAL/INDUSTRIAL/SPECIAL): ");
        String str1 = scanner.nextLine().toUpperCase();
        Property.PropertyType type;
        try {
            type = Property.PropertyType.valueOf(str1.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid property type. Please enter RESIDENTIAL/COMMERCIAL/INDUSTRIAL or SPECIAL. Returning to previous menu.");
            return;
        }
        System.out.print("Enter client's new preferred property status (AVAILABLE/UNDER_CONSTRUCTION/RENTED): ");
        String str2 = scanner.nextLine().toUpperCase();
        Property.PropertyStatus status;
        try {
            status = Property.PropertyStatus.valueOf(str2.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid property status. Please enter AVAILABLE/UNDER_CONSTRUCTION or RENTED. Returning to previous menu.");
            return;
        }
        System.out.print("Enter client's new preferred year of construction: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client's new preferred size (in meters squared): ");
        double size = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter client's new preferred number of rooms: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();
        ClientPreferences clientPreferences = new ClientPreferences(client, budget, location, type, status, year, size, rooms);
        controller.updateClientPreferences(clientPreferences);
    }
    /**
     * Updates an existing client in the real estate agency.
     * Prompts the user to enter the client ID to update, and then enter the new details about the client, including name, email, phone number, and type.
     * Validates the client type, and updates the client in the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void updateClient() {
        System.out.print("Enter client ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new client name: ");
        String name = scanner.nextLine();
        String email;
        while(true) {
            System.out.print("Enter new client email (firstlastname@example.com): ");
            email = scanner.nextLine();
            if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")){
                break;
            }
            else{
                System.out.println("Invalid email address. Returning to previous menu.");
                return;
            }
        }
        System.out.print("Enter new client phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new client type (BUYER/SELLER/RENTER/INVESTOR): ");
        String str2= scanner.nextLine().toUpperCase();
        Client.ClientType type;
        try {
            type = Client.ClientType.valueOf(str2.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid client type. Please enter BUYER/SELLER/RENTER/INVESTOR. Returning to previous menu.");
            return;
        }
        Client client = new Client(id, name, phoneNumber, email, type);
        controller.updateClient(client);
        System.out.println("Client updated successfully.");
    }
    /**
     * Deletes an existing client from the real estate agency.
     * Prompts the user to enter the client ID to delete, and then confirms the deletion.
     * If the user confirms the deletion, the client is removed from the database.
     */
    private void deleteClient() {
        System.out.print("Enter client ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you sure you want to delete this client? (Y/N)");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("N")) {
            System.out.println("Client deletion cancelled. Returning to previous menu.");
        }
        else if(confirmation.equalsIgnoreCase("Y")) {
            controller.deleteClient(id);
            System.out.println("Client deleted successfully.");
        }
    }
    /**
     * Views a client by their ID.
     * Prompts the user to enter the client ID to view, and then displays the client details.
     * If the client is not found, the method returns to the previous menu.
     */
    private int viewClientById() {
        System.out.print("Enter client ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Client client = controller.viewClientById(id);
        ClientPreferences clientPreferences = controller.viewClientPreferencesById(id);
        System.out.println();
        System.out.print(client);
        System.out.print(" + ");
        System.out.print(clientPreferences);
        System.out.println();
        return id;
    }
    /**
     * Views all clients in the real estate agency.
     * Retrieves all clients from the database and displays their details.
     */
    private void viewAllClients() {
        List<Client> clients = controller.viewAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }
        List<ClientPreferences> clientPreferences = controller.viewAllClientPreferences();
        for (ClientPreferences clientPreference : clientPreferences) {
            System.out.println(clientPreference);
        }
    }

    /**
     * Recommends properties for a client based on their preferences.
     * @param id The ID of the client to recommend properties for.
     */
    private void recommendPropertiesForClient(Integer id) {
        controller.recommendPropertiesForClient(id);
    }
    /**
     * Adds a new agent to the real estate agency.
     * Prompts the user to enter various details about the agent, including ID, license number, name, email, and phone number.
     * Validates the email address, and adds the agent to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addAgent() {
        System.out.print("Enter agent ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter agent license number: ");
        int licenseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter agent name: ");
        String name = scanner.nextLine();
        String email;
        while(true) {
            System.out.print("Enter agent email (firstlastname@example.com): ");
            email = scanner.nextLine();
            if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")){
                break;
            }
            else{
                System.out.println("Invalid email address. Returning to previous menu.");
                return;
            }
        }
        System.out.print("Enter agent phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        Agent agent = new Agent(id, name, phoneNumber, email, licenseNumber);
        controller.addAgent(agent);
        System.out.println("Agent added successfully.");
    }
    /**
     * Updates an existing agent in the real estate agency.
     * Prompts the user to enter the agent ID to update, and then enter the new details about the agent, including license number, name, email, and phone number.
     * Validates the email address, and updates the agent in the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void updateAgent() {
        System.out.print("Enter agent ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new agent license number: ");
        int licenseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new agent name: ");
        String name = scanner.nextLine();
        String email;
        while(true) {
            System.out.print("Enter new agent email (firstlastname@example.com): ");
            email = scanner.nextLine();
            if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")){
                break;
            }
            else{
                System.out.println("Invalid email address. Returning to previous menu.");
                return;
            }
        }
        System.out.print("Enter new agent phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        Agent agent = new Agent(id, name, phoneNumber, email, licenseNumber);
        controller.updateAgent(agent);
        System.out.println("Agent updated successfully.");
    }
    /**
     * Deletes an existing agent from the real estate agency.
     * Prompts the user to enter the agent ID to delete, and then confirms the deletion.
     * If the user confirms the deletion, the agent is removed from the database.
     */
    private void deleteAgent() {
        System.out.print("Enter agent ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you sure you want to delete this agent? (Y/N)");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("N")) {
            System.out.println("Agent deletion cancelled. Returning to previous menu.");
        }
        else if(confirmation.equalsIgnoreCase("Y")) {
            controller.deleteAgent(id);
            System.out.println("Agent deleted successfully.");
        }
    }
    /**
     * Views an agent by their ID.
     * Prompts the user to enter the agent ID to view, and then displays the agent details.
     * If the agent is not found, the method returns to the previous menu.
     */
    private int viewAgentById() {
        System.out.print("Enter agent ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Agent agent = controller.viewAgentById(id);
        System.out.println(agent);
        return id;
    }
    /**
     * Views all agents in the real estate agency.
     * Retrieves all agents from the database and displays their details.
     */
    private void viewAllAgents() {
        List<Agent> agents = controller.viewAllAgents();
        for (Agent agent : agents) {
            System.out.println(agent);
        }
    }
    /**
     * Views all properties assigned to an agent.
     * Prompts the user to enter the agent ID to view, and then displays the properties assigned to the agent.
     * If the agent is not found, the method returns to the previous menu.
     */
    private void viewAssignedProperties() {
        try{
        System.out.print("Enter agent ID to view assigned properties: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        List<Property> properties = controller.getPropertiesByAgentId(agentId);
        if (properties.isEmpty()) {
            throw new BusinessLogicException("No properties assigned to agent ID: " + agentId);
        } else {
            System.out.println("--- Properties assigned to agent ID: " + agentId + " ---");
            for (Property property : properties) {
                System.out.println(property);
            }
        }
        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Analyzes the performance of an agent.
     * @param agentID The ID of the agent to analyze.
     */
    private void analyzeAgentPerformance(int agentID) {
        controller.analyzeAgentPerformance(agentID);
    }
    /**
     * Adds a new contract to the real estate agency.
     * Prompts the user to enter various details about the contract, including ID, type, duration, agent ID, client ID, and property ID.
     * Validates the contract type, and adds the contract to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addContract() {
        System.out.print("Enter contract ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter contract type (PURCHASE/LEASE/RENTAL): ");
        String str = scanner.nextLine().toUpperCase();
        Contract.ContractType type;
        try {
            type = Contract.ContractType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid contract type. Please enter PURCHASE, LEASE, or RENTAL. Returning to previous menu.");
            return;
        }
        System.out.print("Enter contract duration (months): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter agent ID: ");
        int agentID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property ID: ");
        int propertyID = scanner.nextInt();
        scanner.nextLine();
        if(controller.propertyUnderContract(propertyID)){
            throw new BusinessLogicException("Property is already under contract.");
        }

        Contract contract = new Contract(id, type, duration, agentID, clientID, propertyID);
        controller.addContract(contract);
        System.out.println("Contract added successfully.");
    }
    /**
     * Updates an existing contract in the real estate agency.
     * Prompts the user to enter the contract ID to update, and then enter the new details about the contract, including type, duration, agent ID, client ID, and property ID.
     * Validates the contract type, and updates the contract in the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void updateContract() {
        System.out.print("Enter contract ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new contract type (PURCHASE/LEASE/RENTAL): ");
        String str = scanner.nextLine().toUpperCase();
        Contract.ContractType type;
        try {
            type = Contract.ContractType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid contract type. Please enter PURCHASE, LEASE, or RENTAL.");
            return;
        }
        System.out.print("Enter new contract duration (months): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new agent ID: ");
        int agentID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new property ID: ");
        int propertyID = scanner.nextInt();
        scanner.nextLine();

        Contract contract = new Contract(id, type, duration, agentID, clientID, propertyID);
        controller.updateContract(contract);
        System.out.println("Contract updated successfully.");
    }
    /**
     * Deletes an existing contract from the real estate agency.
     * Prompts the user to enter the contract ID to delete, and then confirms the deletion.
     * If the user confirms the deletion, the contract is removed from the database.
     */
    private void deleteContract() {
        System.out.print("Enter contract ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you sure you want to delete this contract? (Y/N)");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("N")) {
            System.out.println("Contract deletion cancelled. Returning to previous menu.");
        }
        else if(confirmation.equalsIgnoreCase("Y")) {
            controller.deleteContract(id);
            System.out.println("Contract deleted successfully.");
        }
    }
    /**
     * Views a contract by its ID.
     * Prompts the user to enter the contract ID to view, and then displays the contract details.
     * If the contract is not found, the method returns to the previous menu.
     */
    private void viewContractById() {
        System.out.print("Enter contract ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Contract contract = controller.viewContractById(id);
        System.out.println(contract);
    }
    /**
     * Views all contracts in the real estate agency.
     * Retrieves all contracts from the database and displays their details.
     */
    private void viewAllContracts() {
        List<Contract> contracts = controller.viewAllContracts();
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }
    /**
     * Adds a new review to the property belonging to the real estate agency.
     * Prompts the user to enter various details about the review, including ID, rating, comment, property ID, and client ID.
     * Validates the rating, and adds the review to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addPropertyReview() {
        System.out.print("Enter review ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter rating (between 1 and 5): ");
        int rating = scanner.nextInt();
        if(rating < 1 || rating > 5){
            throw new ValidationException("Invalid rating. Returning to previous menu.");
        }
        scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        System.out.print("Enter property ID: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        Review review = new Review(id, rating, comment, propertyId, clientId);
        controller.addReview(review);
        System.out.println("Review added successfully.");
    }
    /**
     * Adds a new review to the agent belonging to the real estate agency.
     * Prompts the user to enter various details about the review, including ID, rating, comment, agent ID, and client ID.
     * Validates the rating, and adds the review to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addAgentReview() {
        System.out.print("Enter review ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter rating (between 1 and 5): ");
        int rating = scanner.nextInt();
        if(rating < 1 || rating > 5){
            throw new ValidationException("Invalid rating. Returning to previous menu.");
        }
        scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        System.out.print("Enter agent ID: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        Review review = new Review(id, rating, agentId, comment, clientId);
        controller.addReview(review);
        System.out.println("Review added successfully.");
    }
    /**
     * Deletes an existing review from the real estate agency.
     * Prompts the user to enter the review ID to delete, and then confirms the deletion.
     * If the user confirms the deletion, the review is removed from the database.
     */
    private void deleteReview() {
        System.out.print("Enter review ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you sure you want to delete this review? (Y/N)");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("N")){
            System.out.println("Review deletion cancelled. Returning to previous menu.");
        }
        else if(confirmation.equalsIgnoreCase("Y")){
            controller.deleteReview(id);
            System.out.println("Review deleted successfully.");
        }
    }
    /**
     * Views all reviews for a property.
     * Prompts the user to enter the property ID to view, and then displays all reviews for the property.
     */
    private void viewReviewsByProperty() {
        System.out.print("Enter property ID to view reviews: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine();
        List<Review> reviews = controller.viewReviewsByProperty(propertyId);
        if (reviews.isEmpty()) {
            throw new BusinessLogicException("No reviews found for property ID: " + propertyId);
        } else{
            for (Review review : reviews) {
                System.out.println(review);
            }
        }
    }
    /**
     * Views all reviews for an agent.
     * Prompts the user to enter the agent ID to view, and then displays all reviews for the agent.
     */
    private void viewReviewsByAgent() {
        System.out.print("Enter agent ID to view reviews: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        List<Review> reviews = controller.viewReviewsByAgent(agentId);
        if(reviews.isEmpty()){
            throw new BusinessLogicException("No reviews found for agent ID: " + agentId);
        }
        else{
            for (Review review : reviews) {
                System.out.println(review);
            }
        }
    }
    /**
     * Adds a new appointment to the real estate agency.
     * Prompts the user to enter various details about the appointment, including ID, date, agent ID, client ID, and property ID.
     * Validates the date, and adds the appointment to the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void addAppointment() {
        System.out.print("Enter appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        Date date = Date.valueOf(dateString);
        System.out.print("Enter agent ID: ");
        int agentID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property ID: ");
        int propertyID = scanner.nextInt();
        scanner.nextLine();
        Appointment appointment = new Appointment(id, date, agentID, clientID, propertyID);
        controller.addAppointment(appointment);
        System.out.println("Appointment added successfully.");
    }
    /**
     * Updates an existing appointment in the real estate agency.
     * Prompts the user to enter the appointment ID to update, and then enter the new details about the appointment, including date, agent ID, client ID, and property ID.
     * Validates the date, and updates the appointment in the database.
     * If the input is invalid, the method returns to the previous menu.
     */
    private void updateAppointment() {
        System.out.print("Enter appointment ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new appointment date (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        Date date = Date.valueOf(dateString);
        System.out.println("Enter new agent ID: ");
        int agentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new property ID: ");
        int propertyID = scanner.nextInt();
        scanner.nextLine();
        Appointment appointment = new Appointment(id, date, agentID, clientID, propertyID);
        controller.updateAppointment(appointment);
        System.out.println("Appointment updated successfully.");
    }
    /**
     * Deletes an existing appointment from the real estate agency.
     * Prompts the user to enter the appointment ID to delete, and then confirms the deletion.
     * If the user confirms the deletion, the appointment is removed from the database.
     */
    private void deleteAppointment() {
        System.out.print("Enter appointment ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Are you sure you want to delete this appointment? (Y/N)");
        String confirmation = scanner.nextLine();
        if(confirmation.equalsIgnoreCase("N")) {
            System.out.println("Appointment deletion cancelled. Returning to previous menu.");
        }
        else if(confirmation.equalsIgnoreCase("Y")) {
            controller.deleteAppointment(id);
            System.out.println("Appointment deleted successfully.");
        }
    }
    /**
     * Views an appointment by its ID.
     * Prompts the user to enter the appointment ID to view, and then displays the appointment details.
     * If the appointment is not found, the method returns to the previous menu.
     */
    private void viewAppointmentById() {
        System.out.print("Enter appointment ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Appointment appointment = controller.viewAppointmentById(id);
        System.out.println(appointment);
    }
    /**
     * Views all appointments in the real estate agency.
     * Retrieves all appointments from the database and displays their details.
     */
    private void viewAllAppointments() {
        List<Appointment> appointments = controller.viewAllAppointments();
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
    /**
     * Filters reviews by their rating.
     * Prompts the user to enter the minimum rating, and then filters the reviews based on the specified rating.
     * The filtered reviews are displayed to the user.
     */
    private void filterReviewByRating() {
        System.out.println("Enter the minimum rating: ");
        double minRating = scanner.nextDouble();
        List<Review> filteredReviews = controller.filterReviewByRating(minRating);
        for (Review review : filteredReviews) {
            System.out.println(review);
        }
    }
    /**
     * Filters properties by their price range.
     * Prompts the user to enter the minimum and maximum price, and then filters the properties based on the specified price range.
     * The filtered properties are displayed to the user.
     */
    private void filterPropertiesByPrice() {
        System.out.println("Enter minimum price: ");
        int minPrice = scanner.nextInt();
        System.out.println("Enter maximum price: ");
        int maxPrice = scanner.nextInt();
        List<Property> filteredProperties = controller.filterPropertiesByPrice(minPrice, maxPrice);
        for (Property property : filteredProperties) {
            System.out.println(property);
        }
    }
    /**
     * Sorts the list of properties by their price in ascending order.
     * The properties are sorted from the lowest price to the highest price.
     */
    private void sortPropertiesByPrice() {
        List<Property> sortedProperties = controller.sortPropertiesByPrice();
        for (Property property : sortedProperties) {
            System.out.println(property);
        }
    }
    /**
     * Sorts the list of reviews by their rating in descending order.
     * The reviews are sorted from the highest rating to the lowest rating.
     */
    private void sortReviewsByRating() {
        List<Review> sortedReviews = controller.sortReviewsByRating();
        for (Review review : sortedReviews) {
            System.out.println(review);
        }
    }
}