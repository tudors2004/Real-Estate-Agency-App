package UI;
import Controller.Controller;
import Model.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

@SuppressWarnings("DuplicatedCode")
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

    private void manageProperties() {
        while (true) {
            System.out.println("\n--- Manage Properties ---");
            System.out.println("1. Add Property");
            System.out.println("2. Update Property");
            System.out.println("3. Delete Property");
            System.out.println("4. View Property by ID");
            System.out.println("5. View All Properties");
            System.out.println("6. View Unvisited Properties");
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


    private void manageContracts() {
        while (true) {
            System.out.println("\n--- Manage Contracts ---");
            System.out.println("1. Add Contract");
            System.out.println("2. Update Contract");
            System.out.println("3. Delete Contract");
            System.out.println("4. View Contract by ID");
            System.out.println("5. View All Contracts");
            System.out.println("6. Generate Activity Report");
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
                case 6 -> generateActivityReport();
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
            System.out.println("1. Add Property Review");
            System.out.println("2. Add Agent Review");
            System.out.println("3. Delete Review");
            System.out.println("4. View Reviews by Property");
            System.out.println("5. View Reviews by Agent");
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
        Agent associatedAgent = controller.viewAgentById(agentId);
        Property property = new Property(id, type, address, price, year, rooms, status, size, description, associatedAgent);
        controller.addProperty(property);
        controller.linkPropertyAndAgent(agentId, id);
        System.out.println("Property added successfully.");
    }

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
        Agent associatedAgent = controller.viewAgentById(agentId);
        Property property = new Property(id, type, address, price, year, rooms, status, size, description, associatedAgent);
        controller.updateProperty(property);
        controller.linkPropertyAndAgent(agentId, id);
        System.out.println("Property updated successfully.");
    }

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
        System.out.println("List of the unvisited properties: ");
        controller.viewUnvisitedProperties();
    }

    private void addClient() {
        System.out.print("Enter client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
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
        Client client = new Client(id, name, email, phoneNumber, type);
        controller.addClient(client);
        System.out.println("Client added successfully.");
    }

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
        //???????????????????????????????????????????????????????????
        System.out.print("Enter client's new preferred location: ");
        String location = scanner.nextLine();
        //???????????????????????????????????????????????????????????
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
        Client client = new Client(id, name, email, phoneNumber, type);
        controller.updateClient(client);
        System.out.println("Client updated successfully.");
    }

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

    private void recommendPropertiesForClient(Integer id) {
        controller.recommendPropertiesForClient(id);
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
        Agent agent = new Agent(id, licenseNumber, name, email, phoneNumber);
        controller.updateAgent(agent);
        System.out.println("Agent updated successfully.");
    }

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

    private int viewAgentById() {
        System.out.print("Enter agent ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Agent agent = controller.viewAgentById(id);
        System.out.println(agent);
        return id;
    }

    private void viewAllAgents() {
        List<Agent> agents = controller.viewAllAgents();
        for (Agent agent : agents) {
            System.out.println(agent);
        }
    }

    private void viewAssignedProperties() {
        System.out.print("Enter agent ID to view assigned properties: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        Agent agent = controller.viewAgentById(agentId);
        if (agent != null) {
            agent.printAssignedProperties();
        } else {
            System.out.println("Agent not found.");
        }
    }

    private void analyzeAgentPerformance(int agentID) {
        controller.analyzeAgentPerformance(agentID);
    }

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
            System.out.println("Property is already under contract. Returning to previous menu.");
            return;
        }
        Agent agent = controller.viewAgentById(agentID);
        Client client = controller.viewClientById(clientID);
        Property property = controller.viewPropertyById(propertyID);
        Contract contract = new Contract(id, type, duration, agent, client, property);
        controller.addContract(contract);
        System.out.println("Contract added successfully.");
    }

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
        Agent agent = controller.viewAgentById(agentID);
        Client client = controller.viewClientById(clientID);
        Property property = controller.viewPropertyById(propertyID);
        Contract contract = new Contract(id, type, duration, agent, client, property);
        controller.updateContract(contract);
        System.out.println("Contract updated successfully.");
    }

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

    private void generateActivityReport() {
        controller.generateActivityReport();
    }

    private void addPropertyReview() {
        System.out.print("Enter review ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter rating (between 1 and 5): ");
        int rating = scanner.nextInt();
        if(rating < 1 || rating > 5){
            System.out.println("Invalid rating. Returning to previous menu.");
            return;
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
        Property property = controller.viewPropertyById(propertyId);
        Client client = controller.viewClientById(clientId);
        Review review = new Review(id, rating, comment, property, client);
        controller.addReview(review);
        System.out.println("Review added successfully.");
    }

    private void addAgentReview() {
        System.out.print("Enter review ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter rating (between 1 and 5): ");
        int rating = scanner.nextInt();
        if(rating < 1 || rating > 5){
            System.out.println("Invalid rating. Returning to previous menu.");
            return;
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
        Agent agent = controller.viewAgentById(agentId);
        Client client = controller.viewClientById(clientId);
        Review review = new Review(id, rating, comment, agent, client);
        controller.addReview(review);
        System.out.println("Review added successfully.");
    }

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

    private void viewReviewsByProperty() {
        System.out.print("Enter property ID to view reviews: ");
        int propertyId = scanner.nextInt();
        scanner.nextLine();
        List<Review> reviews = controller.viewReviewsByProperty(propertyId);
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    private void viewReviewsByAgent() {
        System.out.print("Enter agent ID to view reviews: ");
        int agentId = scanner.nextInt();
        scanner.nextLine();
        List<Review> reviews = controller.viewReviewsByAgent(agentId);
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
        System.out.print("Enter agent ID: ");
        int agentID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter property ID: ");
        int propertyID = scanner.nextInt();
        scanner.nextLine();
        Agent agent = controller.viewAgentById(agentID);
        Client client = controller.viewClientById(clientID);
        Property property = controller.viewPropertyById(propertyID);
        Appointment appointment = new Appointment(id, date, agent, client, property);
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
        System.out.println("Enter new agent ID: ");
        int agentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new property ID: ");
        int propertyID = scanner.nextInt();
        scanner.nextLine();
        Agent agent = controller.viewAgentById(agentID);
        Client client = controller.viewClientById(clientID);
        Property property = controller.viewPropertyById(propertyID);
        Appointment appointment = new Appointment(id, date, agent, client, property);
        controller.updateAppointment(appointment);
        System.out.println("Appointment updated successfully.");
    }

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
