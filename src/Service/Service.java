package Service;
import Model.*;
import Repository.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final IRepository<Agent> agentRepository;
    private final IRepository<Property> propertyRepository;
    private final IRepository<Contract> contractRepository;
    private final IRepository<Appointment> appointmentRepository;
    private final IRepository<Client> clientRepository;
    private final IRepository<Review> reviewRepository;

    public Service(IRepository<Agent> agent, IRepository<Property> property, IRepository<Contract> contract, IRepository<Appointment> appointment, IRepository<Client> client, IRepository<Review> review) {
        this.agentRepository = agent;
        this.propertyRepository = property;
        this.contractRepository = contract;
        this.appointmentRepository = appointment;
        this.clientRepository = client;
        this.reviewRepository = review;
    }

    public void addProperty(Property property) {
        propertyRepository.create(property);
    }

    public void deleteProperty(int id) {
        propertyRepository.delete(id);
    }

    public void updateProperty(Property property) {
        propertyRepository.update(property);
    }

    public void addAgent(Agent agent) {
        agentRepository.create(agent);
    }

    public void deleteAgent(int id) {
        agentRepository.delete(id);
    }

    public void updateAgent(Agent agent) {
        agentRepository.update(agent);
    }

    public void addContract(Contract contract) {
        contractRepository.create(contract);
    }

    public void deleteContract(int id) {
        contractRepository.delete(id);
    }

    public void updateContract(Contract contract) {
        contractRepository.update(contract);
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.create(appointment);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.delete(id);
    }

    public void updateAppointment(Appointment appointment) {
        appointmentRepository.update(appointment);
    }

    public void addClient(Client client) {
        clientRepository.create(client);
    }

    public void deleteClient(int id) {
        clientRepository.delete(id);
    }

    public void updateClient(Client client) {
        clientRepository.update(client);
    }
    public void addReview(Review review){
        reviewRepository.create(review);
    }
    public void deleteReview(int id){
        reviewRepository.delete(id);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.getAll();
    }

    public List<Agent> getAllAgents() {
        return agentRepository.getAll();
    }

    public List<Contract> getAllContracts() {
        return contractRepository.getAll();
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }

    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    public List<Review> getAllReviews() {
        return reviewRepository.getAll();
    }

    public Agent getAgentById(int agentId) {
        return agentRepository.read(agentId);
    }

    public Property getPropertyById(int propertyID) {
        return propertyRepository.read(propertyID);
    }

    public Client getClientById(int clientID) {
        return clientRepository.read(clientID);
    }

    public Contract getContractById(int contractID) {
        return contractRepository.read(contractID);
    }

    public Appointment getAppointmentById(int appointmentID) {
        return appointmentRepository.read(appointmentID);
    }

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
    }

    public void recommendPropertiesForClient(){

    }

    public void analyzeAgentPerformance(){
        //TODO: Calculeaza numarul de contracte pe care le are agentul si face media reviews-urilor si le aduna
    }

    public void generateActivityReport(){
        System.out.println("--Activity report--\n" +
                "Number of properties: " + getAllProperties().size() + "\n" +
                "Number of contracts: " + getAllContracts().size() + "\n" +
                "Number of appointments: " + getAllAppointments().size() + "\n" +
                "Number of clients: " + getAllClients().size() + "\n" +
                "Number of reviews: " + getAllReviews().size());
    }

}
