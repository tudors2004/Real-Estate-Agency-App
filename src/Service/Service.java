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

    public Property getPropertyById(int id) {
        return propertyRepository.read(id);
    }

    public Client getClientById(int id) {
        return clientRepository.read(id);
    }

    public Contract getContractById(int id) {
        return contractRepository.read(id);
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.read(id);
    }

    public List<Review> getReviewsByProperty(int propertyId) {
        return null;
//        List<Review> reviews = new ArrayList<>();
//        for (Review review : reviewRepository.getAll()) {
//            if (review.getPropertyId() == propertyId) {
//                reviews.add(review);
//            }
//        }
//        return reviews;
    }

    public void linkPropertyAndClient(int contractId, int propertyId, int clientId) {
//        Contract contract = contractRepository.read(contractId);
//        contract.setPropertyId(propertyId);
//        contract.setClientId(clientId);
//        contractRepository.update(contract);
    }
}
