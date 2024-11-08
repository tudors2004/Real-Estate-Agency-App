package Controller;
import Service.Service;
import Model.*;
import java.util.List;
public class Controller {
    private final Service service;
    public Controller(Service service) {
        this.service = service;
    }
    public void addProperty(Property property) {
        service.addProperty(property);
    }

    public void deleteProperty(int id) {
        service.deleteProperty(id);
    }

    public void updateProperty(Property property) {
        service.updateProperty(property);
    }

    public void addAgent(Agent agent) {
        service.addAgent(agent);
    }

    public void deleteAgent(int id) {
        service.deleteAgent(id);
    }

    public void updateAgent(Agent agent) {
        service.updateAgent(agent);
    }

    public void addContract(Contract contract) {
        service.addContract(contract);
    }

    public void deleteContract(int id) {
        service.deleteContract(id);
    }

    public void updateContract(Contract contract) {
        service.updateContract(contract);
    }

    public void addAppointment(Appointment appointment) {
        service.addAppointment(appointment);
    }

    public void deleteAppointment(int id) {
        service.deleteAppointment(id);
    }

    public void updateAppointment(Appointment appointment) {
        service.updateAppointment(appointment);
    }

    public void addClient(Client client) {
        service.addClient(client);
    }

    public void deleteClient(int id) {
        service.deleteClient(id);
    }

    public void updateClient(Client client) {
        service.updateClient(client);
    }
    public void addReview(Review review) {
        service.addReview(review);
    }
    public void deleteReview(int id) {
        service.deleteReview(id);
    }
    public List<Property> viewAllProperties() {
        return service.getAllProperties();
    }
    public List<Agent> viewAllAgents() {
        return service.getAllAgents();
    }
    public List<Contract> viewAllContracts() {
        return service.getAllContracts();
    }
    public List<Appointment> viewAllAppointments() {
        return service.getAllAppointments();
    }
    public List<Client> viewAllClients() {
        return service.getAllClients();
    }
    public List<Review> viewAllReviews() {
        return service.getAllReviews();
    }

    public Agent viewAgentById(int agentId) {
        return service.getAgentById(agentId);
    }

    public Property viewPropertyById(int propertyID) {
        return service.getPropertyById(propertyID);
    }

    public Client viewClientById(int clientID) {
        return service.getClientById(clientID);
    }

    public Contract viewContractById(int contractID) {
        return service.getContractById(contractID);
    }

    public List<Review> viewReviewsByProperty(int propertyId) {
        return service.getReviewsByProperty(propertyId);
    }

    public Appointment viewAppointmentById(int appointmentID) {
        return service.getAppointmentById(appointmentID);
    }

    public void viewUnvisitedProperties() {
        service.viewUnvisitedProperties();
    }
    public void recommendPropertiesForClient() {
        service.recommendPropertiesForClient();
    }
    public void analyzeAgentPerformance() {
        service.analyzeAgentPerformance();
    }
    public void generateActivityReport() {
        service.generateActivityReport();
    }
    public void linkPropertyAndAgent(int agentID, int propertyID){
        service.linkPropertyAndAgent(agentID, propertyID);
    }

    public void linkPropertyAndClient(int propertyId, int clientId) {
        service.linkPropertyAndClient(propertyId, clientId);
    }
}
