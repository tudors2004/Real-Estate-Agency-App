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
        List<Review> reviews = reviewRepository.getAll();
        List<Review> propertyReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProperty().getId() == propertyId) {
                propertyReviews.add(review);
            }
        }
        return propertyReviews;
    }

    public void linkPropertyAndClient(int propertyId, int clientId){
        Property property = propertyRepository.read(propertyId);
        Client client = clientRepository.read(clientId);
        //TODO: Link property to client
    }

    public void linkPropertyAndAgent(int propertyId, int agentId) {
        Property property = propertyRepository.read(propertyId);
        Agent agent = agentRepository.read(agentId);

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
            if (property.getAssociatedAgent() == null) {
                unvisitedProperties.add(property);
            }
        }
        for (Property property : unvisitedProperties) {
            System.out.println(property);
        }
    }

    public void recommendPropertiesForClient(){
        //TODO: Recomanda clientului proprietati in functie de preferintele lui
    }

    public void analyzeAgentPerformance(){
        //TODO: Calculeaza numarul de contracte pe care le are agentul si face media reviews-urilor si le aduna
    }

    public void generateActivityReport(){
        System.out.println("--Activity report--\n" +
                "Number of properties: " + propertyRepository.getAll().size() + "\n" +
                "Number of contracts: " + contractRepository.getAll().size() + "\n" +
                "Number of appointments: " + appointmentRepository.getAll().size() + "\n" +
                "Number of clients: " + clientRepository.getAll().size() + "\n" +
                "Number of reviews: " + reviewRepository.getAll().size());
    }

}
