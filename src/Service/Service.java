package Service;
import Model.*;
import Repository.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * The Service class serves as the business logic layer, managing operations on
 * entities such as agents, properties, contracts, appointments, clients, reviews,
 * and client preferences.
 */
public class Service {
    private final IRepository<Agent> agentRepository;
    private final IRepository<Property> propertyRepository;
    private final IRepository<Contract> contractRepository;
    private final IRepository<Appointment> appointmentRepository;
    private final IRepository<Client> clientRepository;
    private final IRepository<Review> reviewRepository;
    private final IRepository<ClientPreferences> clientPreferencesRepository;
    /**
     * Constructs a Service with the specified repositories for each entity type.
     *
     * @param agent               Repository for managing Agent entities.
     * @param property            Repository for managing Property entities.
     * @param contract            Repository for managing Contract entities.
     * @param appointment         Repository for managing Appointment entities.
     * @param client              Repository for managing Client entities.
     * @param review              Repository for managing Review entities.
     * @param clientPreferences   Repository for managing ClientPreferences entities.
     */
    public Service(IRepository<Agent> agent, IRepository<Property> property, IRepository<Contract> contract, IRepository<Appointment> appointment, IRepository<Client> client, IRepository<Review> review, IRepository<ClientPreferences> clientPreferences) {
        this.agentRepository = agent;
        this.propertyRepository = property;
        this.contractRepository = contract;
        this.appointmentRepository = appointment;
        this.clientRepository = client;
        this.reviewRepository = review;
        this.clientPreferencesRepository = clientPreferences;
    }
    /**
     * Adds a new property to the repository.
     *
     * @param property The Property object to be added.
     */
    public void addProperty(Property property) {
        propertyRepository.create(property);
    }
    /**
     * Deletes a property from the repository.
     *
     * @param id The ID of the property to delete.
     */
    public void deleteProperty(int id) {
        propertyRepository.delete(id);
    }
    /**
     * Updates an existing property in the repository.
     *
     * @param property The Property object to be updated.
     */
    public void updateProperty(Property property) {
        propertyRepository.update(property);
    }
    /**
     * Adds a new agent to the repository.
     *
     * @param agent The Agent object to be added.
     */
    public void addAgent(Agent agent) {
        agentRepository.create(agent);
    }
    /**
     * Deletes an agent from the repository.
     *
     * @param id The ID of the agent to delete.
     */
    public void deleteAgent(int id) {
        agentRepository.delete(id);
    }
    /**
     * Updates an existing agent in the repository.
     *
     * @param agent The Agent object to be updated.
     */
    public void updateAgent(Agent agent) {
        agentRepository.update(agent);
    }
    /**
     * Adds a new contract to the repository.
     *
     * @param contract The Contract object to be added.
     */
    public void addContract(Contract contract) {
        contractRepository.create(contract);
    }
    /**
     * Deletes a contract from the repository.
     *
     * @param id The ID of the contract to delete.
     */
    public void deleteContract(int id) {
        contractRepository.delete(id);
    }
    /**
     * Updates an existing contract in the repository.
     *
     * @param contract The Contract object to be updated.
     */
    public void updateContract(Contract contract) {
        contractRepository.update(contract);
    }
    /**
     * Adds a new appointment to the repository.
     *
     * @param appointment The Appointment object to be added.
     */
    public void addAppointment(Appointment appointment) {
        appointmentRepository.create(appointment);
    }
    /**
     * Deletes an appointment from the repository.
     *
     * @param id The ID of the appointment to delete.
     */
    public void deleteAppointment(int id) {
        appointmentRepository.delete(id);
    }
    /**
     * Updates an existing appointment in the repository.
     *
     * @param appointment The Appointment object to be updated.
     */
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.update(appointment);
    }
    /**
     * Adds a new client to the repository.
     *
     * @param client The Client object to be added.
     */
    public void addClient(Client client) {
        clientRepository.create(client);
    }
    /**
     * Deletes a client from the repository.
     *
     * @param id The ID of the client to delete.
     */
    public void deleteClient(int id) {
        clientRepository.delete(id);
    }
    /**
     * Updates an existing client in the repository.
     *
     * @param client The Client object to be updated.
     */
    public void updateClient(Client client) {
        clientRepository.update(client);
    }
    /**
     * Adds a new review to the repository.
     *
     * @param review The Review object to be added.
     */
    public void addReview(Review review){
        reviewRepository.create(review);
    }
    /**
     * Deletes a review from the repository.
     *
     * @param id The ID of the review to delete.
     */
    public void deleteReview(int id){
        reviewRepository.delete(id);
    }

    /**
     * Adds a new client preferences to the repository.
     * @param clientPreferences The client preferences object to be added.
     */
    public void addClientPreferences(ClientPreferences clientPreferences){
        clientPreferencesRepository.create(clientPreferences);
    }
    /**
     * Updates the provided client preferences in the system.
     *
     * @param clientPreferences The client preferences object with updated information.
     */
    public void updateClientPreferences(ClientPreferences clientPreferences){
        clientPreferencesRepository.update(clientPreferences);
    }
    /**
     * Retrieves a list of all properties stored in the system.
     *
     * @return A list of all Property objects.
     */
    public List<Property> getAllProperties() {
        return propertyRepository.getAll();
    }
    /**
     * Retrieves a list of all agents stored in the system.
     *
     * @return A list of all Agent objects.
     */
    public List<Agent> getAllAgents() {
        return agentRepository.getAll();
    }
    /**
     * Retrieves a list of all contracts stored in the system.
     *
     * @return A list of all Contract objects.
     */
    public List<Contract> getAllContracts() {
        return contractRepository.getAll();
    }
    /**
     * Retrieves a list of all appointments stored in the system.
     *
     * @return A list of all Appointment objects.
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }
    /**
     * Retrieves a list of all clients stored in the system.
     *
     * @return A list of all Client objects.
     */
    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }
    /**
     * Retrieves a list of all client preferences stored in the system.
     *
     * @return A list of all ClientPreferences objects.
     */
    public List<ClientPreferences> getAllClientPreferences() {
        return clientPreferencesRepository.getAll();
    }
    /**
     * Retrieves a list of all reviews stored in the system.
     *
     * @return A list of all Review objects.
     */
    public List<Review> getAllReviews() {
        return reviewRepository.getAll();
    }
    /**
     * Retrieves an agent object from the system based on the provided ID.
     *
     * @param agentId The ID of the agent to retrieve.
     * @return The Agent object with the matching ID, or null if not found.
     */
    public Agent getAgentById(int agentId) {
        return agentRepository.read(agentId);
    }
    /**
     * Retrieves a property object from the system based on the provided ID.
     *
     * @param propertyID The ID of the property to retrieve.
     * @return The Property object with the matching ID, or null if not found.
     */
    public Property getPropertyById(int propertyID) {
        return propertyRepository.read(propertyID);
    }
    /**
     * Retrieves a client preferences object from the system based on the provided client ID.
     *
     * @param clientId The ID of the client to retrieve preferences for.
     * @return The ClientPreferences object with the matching client ID, or null if not found.
     */
    public ClientPreferences getClientPreferencesByClientId(Integer clientId) {
        return clientPreferencesRepository.read(clientId);
    }
    /**
     * Retrieves a client object from the system based on the provided ID.
     *
     * @param clientID The ID of the client to retrieve.
     * @return The Client object with the matching ID, or null if not found.
     */
    public Client getClientById(int clientID) {
        return clientRepository.read(clientID);
    }
    /**
     * Retrieves a contract object from the system based on the provided ID.
     *
     * @param contractID The ID of the contract to retrieve.
     * @return The Contract object with the matching ID, or null if not found.
     */
    public Contract getContractById(int contractID) {
        return contractRepository.read(contractID);
    }
    /**
     * Retrieves an appointment object from the system based on the provided ID.
     *
     * @param appointmentID The ID of the appointment to retrieve.
     * @return The Appointment object with the matching ID, or null if not found.
     */
    public Appointment getAppointmentById(int appointmentID) {
        return appointmentRepository.read(appointmentID);
    }
    /*TODO: Cele 2 metode de mai jos cred ca se potrivesc pt cerinta 3 de la ultima tema
       Adica ambele filtreaza recenziile pentru o proprietate respectiv un agent
    */
    /**
     * Retrieves all reviews related to a specific property.
     *
     * @param propertyId The ID of the property.
     * @return A list of Review objects associated with the specified property.
     */
    public List<Review> getReviewsByProperty(int propertyId) {
        List<Review> reviews = getAllReviews();
        List<Review> propertyReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProperty().getId() == propertyId) {
                propertyReviews.add(review);
            }
        }
        return propertyReviews;
    }
    /**
     * Retrieves all reviews related to a specific agent.
     *
     * @param agentId The ID of the agent.
     * @return A list of Review objects associated with the specified agent.
     */
    public List<Review> getReviewsByAgent(int agentId) {
        List<Review> reviews = getAllReviews();
        List<Review> agentReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getAgent().getId() == agentId) {
                agentReviews.add(review);
            }
        }
        return agentReviews;
    }
//    public void linkContract(int agentId, int clientId ) {
//        List<Contract> contracts = getAllContracts();
//        Agent agent=getAgentById(agentId);
//        Client client=getClientById(clientId);
//        if(agent==null){
//            throw new RuntimeException("Agent "+agentId+" not found");
//        }
//        if(client==null){
//            throw new RuntimeException("Client "+clientId+" not found");
//        }
//        for(Contract contract : contracts){
//            if(!contract.getAgent() && !contract.getClient().getId()==client){
//                contractRepository.create(contract);
//            }
//        }
//    }
    /**
     * Links a property to a client, marking that the client has viewed the
     * property.
     *
     * @param propertyId The ID of the property.
     * @param clientId   The ID of the client.
     */
    public void linkPropertyAndClient(int propertyId, int clientId){
        Property property = getPropertyById(propertyId);
        Client client = getClientById(clientId);
        if (client == null) {
            System.out.println("Client with ID " + clientId + " not found.");
            return;
        }
        if (property == null) {
            System.out.println("Property with ID " + propertyId + " not found.");
            return;
        }
        if (client.getSeeProperty() == null) {
            client.setSeeProperty(new ArrayList<>());
        }
        if (!client.getSeeProperty().contains(property) || !property.getSeenByClient().contains(client)) {
            client.getSeeProperty().add(property);
            property.getSeenByClient().add(client);
        }
    }
    /**
     * Links a property to an agent, marking that the agent is associated with
     * the property.
     *
     * @param propertyId The ID of the property.
     * @param agentId    The ID of the agent.
     */
    public void linkPropertyAndAgent(int propertyId, int agentId) {
        Property property = getPropertyById(propertyId);
        Agent agent = getAgentById(agentId);

        if (property != null && agent != null) {
            property.setAssociatedAgent(agent);
            agent.getAssignedProperty().add(property);
            propertyRepository.update(property);
            agentRepository.update(agent);
        }
        else {
            System.out.println("Property not found.");
        }
    }
    /**
     * Displays all properties that have not been visited by any clients.
     */
    public void viewUnvisitedProperties(){
        List<Property> unvisitedProperties = new ArrayList<>();
        for (Property property : propertyRepository.getAll()) {
            if (property.getSeenByClient() == null) {
                unvisitedProperties.add(property);
            }
        }
        for (Property property : unvisitedProperties) {
            System.out.println(property);
        }
        if(unvisitedProperties.isEmpty()){
            System.out.println("No unvisited properties found.");
        }else {
            for (Property property : unvisitedProperties) {
                System.out.println(property);
            }
        }
    }
    /**
     * Recommends properties for a client based on their preferences.
     *
     * @param ClientID The ID of the client.
     */
    public void recommendPropertiesForClient(Integer ClientID){
        Client client = getClientById(ClientID);
       ClientPreferences preferences=getClientPreferencesByClientId(ClientID);
        List<Property> allProperties = getAllProperties();
        List<Property> recommendedProperties = new ArrayList<>();
            if(client==null){
                System.out.println("Client with ID " + ClientID + " not found.");
                return;
            }
            if(preferences==null){
                System.out.println("Preferences not found.");
                return;
            }
            for (Property property : allProperties) {
                if(preferences.matchesPreferences(property)){
                    recommendedProperties.add(property);
                }
            }
        if (recommendedProperties.isEmpty()) {
            System.out.println("No properties match the preferences of client ID " + ClientID + ".");
        } else {
            System.out.println("Recommended properties for client ID " + ClientID + ": " + recommendedProperties);
        }
    }

    public int countPropertiesListed(int month, int year){
        List<Property> allProperties = getAllProperties();
        int count=0;
        for (Property property : allProperties) {
            if (property.getListedDate().getMonthValue() == month &&
                    property.getListedDate().getYear() == year) {
                count++;
            }
        }
        return count;
    }

    public int countPropertiesSold(int month, int year){
        List<Property> allProperties = getAllProperties();
        int count=0;
        for (Property property : allProperties) {
            if(property.getSoldDate().getMonthValue()==month && property.getSoldDate().getYear()==year){
                count++;
            }
        }
        return count;
    }
    public int countVisitedProperties() {
        int visitedCount = 0;
        for (Property property : propertyRepository.getAll()) {
            if (property.getSeenByClient() != null && !property.getSeenByClient().isEmpty()) {
                visitedCount++;
            }
        }
        return visitedCount;
    }
    public int generateMonthlyActivityReport(Integer month, Integer year){
        Integer propertiesListed=countPropertiesListed(month, year);
        Integer propertiesSold=countPropertiesSold(month, year);
        int count=0;
        List<Property> allProperties = getAllProperties();
        for(Property property : allProperties){
            if (property.getListedDate().getMonthValue() == month && property.getListedDate().getYear() == year) {
                count++;
            }
        }
        return count;
    }
    //TODO: e deja un generateActivityReport care face cam acelasi lucru

    /**
     * Analyzes an agent's performance based on reviews and contracts.
     *
     * @param AgentID The ID of the agent.
     */
    //TODO: Metoda asta cred ca se potriveste pentru cerinta 4 din ultima tema!!!!!!!!!!! (are 3 entitati)
    public void analyzeAgentPerformance(Integer AgentID){
            List<Review> reviews = getAllReviews();
            List<Contract> contracts = getAllContracts();
            Agent agent = getAgentById(AgentID);

            if (agent == null) {
                System.out.println("Agent with ID " + AgentID + " not found.");
                return;
            }

            double totalRating = 0;
            int ratingCount = 0;
            for (Review review : reviews) {
                if (review.getAgent() != null && Objects.equals(review.getAgent().getId(), AgentID)) {
                    totalRating += review.getRating();
                    ratingCount++;
                } else if (review.getProperty() != null && Objects.equals(review.getProperty().getAssociatedAgent().getId(), AgentID)) {
                    totalRating += review.getRating();
                    ratingCount++;
                }
            }
            double averageRating = (ratingCount > 0) ? totalRating / ratingCount : 0;


            int contractCount = 0;
            for (Contract contract : contracts) {
                if (Objects.equals(contract.getAgent().getId(), AgentID)) {
                    contractCount++;
                }
            }

            System.out.println("Performance analysis for Agent " + AgentID + ":");
            System.out.println("Average Rating: " + averageRating + " stars");
            System.out.println("Number of Contracts: " + contractCount);

            if (averageRating >= 4.5 && contractCount >= 10) {
                System.out.println("This agent is performing excellently!");
            } else if (averageRating >= 3.5) {
                System.out.println("This agent is performing well.");
            } else {
                System.out.println("This agent needs improvement.");
            }
    }
    /**
     * Generates a report on the current activity, including counts of all main
     * entities in the system.
     */
    public void generateActivityReport(){
        System.out.println("--Activity report--\n" +
                "Number of properties: " + getAllProperties().size() + "\n" +
                "Number of contracts: " + getAllContracts().size() + "\n" +
                "Number of appointments: " + getAllAppointments().size() + "\n" +
                "Number of clients: " + getAllClients().size() + "\n" +
                "Number of reviews: " + getAllReviews().size());
    }
    /**
     * Checks if a property is currently under contract.
     *
     * @param propertyID The ID of the property.
     * @return true if the property is under contract; false otherwise.
     */
    public boolean isPropertyUnderContract(int propertyID) {
        List<Contract> contracts = getAllContracts();
        for (Contract contract : contracts) {
            if (contract.getProperty().getId() == propertyID) {
                return true;
            }
        }
        return false;
    }
}
