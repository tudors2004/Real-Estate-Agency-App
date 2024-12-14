package org.example.Controller;
import org.example.Service.Service;
import org.example.Model.*;
import java.util.List;
import org.example.Exceptions.*;
/**
 * The Controller class is an intermediary between the UI and service,
 * providing methods to manage properties, agents, contracts,
 * appointments, clients, reviews, and client preferences.
 */
public class Controller {
    private final Service service;
    /**
     * Constructor to initialize the Controller with a Service instance.
     *
     * @param service The service layer instance that handles the business logic.
     */
    public Controller(Service service) {
        this.service = service;
    }
    /**
     * Adds a new property to the system.
     *
     * @param property The Property object to add.
     */
    public void addProperty(Property property) {
        if(property == null) {
            throw new ValidationException("Property cannot be null");
        }
        service.addProperty(property);
    }
    /**
     * Deletes a property by its ID.
     *
     * @param id The ID of the property to delete.
     */
    public void deleteProperty(int id) {
        if(id <= 0) {
            throw new ValidationException("Property ID must be greater than 0");
        }
        service.deleteProperty(id);
    }
    /**
     * Updates an existing property.
     *
     * @param property The Property object with updated details.
     */
    public void updateProperty(Property property) {
        if(property == null || property.getId() <= 0) {
            throw new ValidationException("Property is invalid. Ensure it is not null and has a valid ID.");
        }
        service.updateProperty(property);
    }
    /**
     * Adds a new agent to the system.
     *
     * @param agent The Agent object to add.
     */
    public void addAgent(Agent agent) {
        if(agent == null) {
            throw new ValidationException("Agent cannot be null");
        }
        service.addAgent(agent);
    }
    /**
     * Deletes an agent by their ID.
     *
     * @param id The ID of the agent to delete.
     */
    public void deleteAgent(int id) {
        if(id <= 0) {
            throw new ValidationException("Agent ID must be greater than 0");
        }
        service.deleteAgent(id);
    }
    /**
     * Updates an existing agent.
     *
     * @param agent The Agent object with updated details.
     */
    public void updateAgent(Agent agent) {
        if(agent == null || agent.getId() <= 0) {
            throw new ValidationException("Agent is invalid. Ensure it is not null and has a valid ID.");
        }
        service.updateAgent(agent);
    }
    /**
     * Adds a new contract to the system.
     *
     * @param contract The Contract object to add.
     */
    public void addContract(Contract contract) {
        if(contract == null) {
            throw new ValidationException("Contract cannot be null");
        }
        service.addContract(contract);
    }
    /**
     * Deletes a contract by its ID.
     *
     * @param id The ID of the contract to delete.
     */
    public void deleteContract(int id) {
        if(id <= 0) {
            throw new ValidationException("Contract ID must be greater than 0");
        }
        service.deleteContract(id);
    }
    /**
     * Updates an existing contract.
     *
     * @param contract The Contract object with updated details.
     */
    public void updateContract(Contract contract) {
        if(contract == null || contract.getId() <= 0) {
            throw new ValidationException("Contract is invalid. Ensure it is not null and has a valid ID.");
        }
        service.updateContract(contract);
    }
    /**
     * Adds a new appointment to the system.
     *
     * @param appointment The Appointment object to add.
     */
    public void addAppointment(Appointment appointment) {
        if(appointment == null) {
            throw new ValidationException("Appointment cannot be null");
        }
        service.addAppointment(appointment);
    }
    /**
     * Deletes an appointment by its ID.
     *
     * @param id The ID of the appointment to delete.
     */
    public void deleteAppointment(int id) {
        if(id <= 0) {
            throw new ValidationException("Appointment ID must be greater than 0");
        }
        service.deleteAppointment(id);
    }
    /**
     * Updates an existing appointment.
     *
     * @param appointment The Appointment object with updated details.
     */
    public void updateAppointment(Appointment appointment) {
        if(appointment == null || appointment.getId() <= 0) {
            throw new ValidationException("Appointment is invalid. Ensure it is not null and has a valid ID.");
        }
        service.updateAppointment(appointment);
    }
    /**
     * Adds a new client to the system.
     *
     * @param client The Client object to add.
     */
    public void addClient(Client client) {
        if(client == null) {
            throw new ValidationException("Client cannot be null");
        }
        service.addClient(client);
    }
    /**
     * Deletes a client by their ID.
     *
     * @param id The ID of the client to delete.
     */
    public void deleteClient(int id) {
        if(id <= 0) {
            throw new ValidationException("Client ID must be greater than 0");
        }
        service.deleteClient(id);
    }
    /**
     * Updates an existing client.
     *
     * @param client The Client object with updated details.
     */
    public void updateClient(Client client) {
        if(client == null || client.getId() <= 0) {
            throw new ValidationException("Client is invalid. Ensure it is not null and has a valid ID.");
        }
        service.updateClient(client);
    }
    /**
     * Adds a new review to the system.
     *
     * @param review The Review object to add.
     */
    public void addReview(Review review) {
        if(review == null) {
            throw new ValidationException("Review cannot be null");
        }
        service.addReview(review);
    }
    /**
     * Deletes a review by its ID.
     *
     * @param id The ID of the review to delete.
     */
    public void deleteReview(int id) {
        if(id <= 0) {
            throw new ValidationException("Review ID must be greater than 0");
        }
        service.deleteReview(id);
    }
    /**
     * Retrieves a list of all properties.
     *
     * @return A List of Property objects.
     */
    public List<Property> viewAllProperties() {
        return service.getAllProperties();
    }
    /**
     * Retrieves a list of all agents.
     *
     * @return A List of Agent objects.
     */
    public List<Agent> viewAllAgents() {
        return service.getAllAgents();
    }
    /**
     * Retrieves a list of all contracts.
     *
     * @return A List of Contract objects.
     */
    public List<Contract> viewAllContracts() {
        return service.getAllContracts();
    }
    /**
     * Retrieves a list of all appointments.
     *
     * @return A List of Appointment objects.
     */
    public List<Appointment> viewAllAppointments() {
        return service.getAllAppointments();
    }
    /**
     * Retrieves a list of all clients.
     *
     * @return A List of Client objects.
     */
    public List<Client> viewAllClients() {
        return service.getAllClients();
    }
    /**
     * Retrieves a list of all reviews.
     *
     * @return A List of Review objects.
     */
    public List<Review> viewAllReviews() {
        return service.getAllReviews();
    }
    /**
     * Retrieves an agent by their ID.
     *
     * @param agentId The ID of the agent.
     * @return The Agent object with the specified ID.
     */
    public Agent viewAgentById(int agentId) {
        if(agentId <= 0) {
            throw new ValidationException("Agent ID must be greater than 0");
        }
        return service.getAgentById(agentId);
    }
    /**
     * Retrieves a property by its ID.
     *
     * @param propertyID The ID of the property.
     * @return The Property object with the specified ID.
     */
    public Property viewPropertyById(int propertyID) {
        if(propertyID <= 0) {
            throw new ValidationException("Property ID must be greater than 0");
        }
        return service.getPropertyById(propertyID);
    }
    /**
     * Retrieves a client by their ID.
     *
     * @param clientID The ID of the client.
     * @return The Client object with the specified ID.
     */
    public Client viewClientById(int clientID) {
        if(clientID <= 0) {
            throw new ValidationException("Client ID must be greater than 0");
        }
        return service.getClientById(clientID);
    }
    /**
     * Retrieves a contract by its ID.
     *
     * @param contractID The ID of the contract.
     * @return The Contract object with the specified ID.
     */
    public Contract viewContractById(int contractID) {
        if(contractID <= 0) {
            throw new ValidationException("Contract ID must be greater than 0");
        }
        return service.getContractById(contractID);
    }
    /**
     * Retrieves all reviews associated with a specific property.
     *
     * @param propertyId The ID of the property.
     * @return A List of Review objects associated with the specified property.
     */
    public List<Review> viewReviewsByProperty(int propertyId) {
        if(propertyId <= 0) {
            throw new ValidationException("Property ID must be greater than 0");
        }
        return service.getReviewsByProperty(propertyId);
    }
    /**
     * Retrieves all reviews associated with a specific agent.
     *
     * @param agentId The ID of the agent.
     * @return A List of Review objects associated with the specified agent.
     */
    public List<Review> viewReviewsByAgent(int agentId) {
        if(agentId <= 0) {
            throw new ValidationException("Agent ID must be greater than 0");
        }
        return service.getReviewsByAgent(agentId);
    }
    /**
     * Retrieves an appointment by its ID.
     *
     * @param appointmentID The ID of the appointment.
     * @return The Appointment object with the specified ID.
     */
    public Appointment viewAppointmentById(int appointmentID) {
        if(appointmentID <= 0) {
            throw new ValidationException("Appointment ID must be greater than 0");
        }
        return service.getAppointmentById(appointmentID);
    }
    /**
     * Recommends properties for a specific client based on their preferences.
     *
     * @param clientID The ID of the client.
     */
    public void recommendPropertiesForClient(Integer clientID) {
        if(clientID <= 0){
            throw new ValidationException("Client ID must be greater than 0");
        }
        service.recommendPropertiesForClient(clientID);
    }
    /**
     * Analyzes the performance of a specific agent.
     *
     * @param agentID The ID of the agent.
     */
    public void analyzeAgentPerformance(Integer agentID) {
        if(agentID <= 0){
            throw new ValidationException("Agent ID must be greater than 0");
        }
        service.analyzeAgentPerformance(agentID);
    }
    /**
     * Links a property to an agent.
     *
     * @param agentID The ID of the agent.
     * @param propertyID The ID of the property.
     */
    public void linkPropertyAndAgent(int agentID, int propertyID){
        if(agentID <= 0 || propertyID <= 0){
            throw new ValidationException("Agent ID and Property ID must be greater than 0");
        }
        service.linkPropertyAndAgent(agentID, propertyID);
    }
//    /**
//     * Links a property to a client.
//     *
//     * @param propertyId The ID of the property.
//     * @param clientId The ID of the client.
//     */
//    public void linkPropertyAndClient(int propertyId, int clientId) {
//        service.linkPropertyAndClient(propertyId, clientId);
//    }
//    /**
//     * Displays all unvisited properties.
//     */
//    public void viewUnvisitedProperties() {
//        service.viewUnvisitedProperties();
//    }
    /**
     * Adds client preferences to the system.
     *
     * @param clientPreferences The ClientPreferences object to add.
     */
    public void addClientPreferences(ClientPreferences clientPreferences) {
        if(clientPreferences == null) {
            throw new ValidationException("ClientPreferences cannot be null");
        }
        service.addClientPreferences(clientPreferences);
    }
    /**
     * Updates an existing client's preferences.
     *
     * @param clientPreferences The ClientPreferences object with updated details.
     */
    public void updateClientPreferences(ClientPreferences clientPreferences) {
        if(clientPreferences == null || clientPreferences.getId() <= 0) {
            throw new ValidationException("ClientPreferences is invalid. Ensure it is not null and has a valid client ID.");
        }
        service.updateClientPreferences(clientPreferences);
    }
    /**
     * Retrieves a list of all client preferences.
     *
     * @return A List of ClientPreferences objects.
     */
    public List<ClientPreferences> viewAllClientPreferences() {
        return service.getAllClientPreferences();
    }
    /**
     * Retrieves client preferences by their ID.
     *
     * @param clientId The ID of the client.
     * @return The ClientPreferences object with the specified client ID.
     */
    public ClientPreferences viewClientPreferencesById(int clientId) {
        if(clientId <= 0) {
            throw new ValidationException("Client ID must be greater than 0");
        }
        return service.getClientPreferencesByClientId(clientId);
    }
    /**
     * Checks if a property is under contract.
     *
     * @param propertyID The ID of the property.
     * @return True if the property is under contract, false otherwise.
     */
    public boolean propertyUnderContract(int propertyID) {
        return service.isPropertyUnderContract(propertyID);
    }
    /**
     * Filters properties by their price range.
     *
     * @param minPrice The minimum price of the properties to filter.
     * @param maxPrice The maximum price of the properties to filter.
     * @return A list of properties within the specified price range.
     */
    public List<Property> filterPropertiesByPrice(int minPrice, int maxPrice) {
        if(minPrice < 0 || maxPrice < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        return service.filterPropertyByPrice(minPrice, maxPrice);
    }
    /**
     * Filters reviews by their rating.
     *
     * @param rating The minimum rating of the reviews to filter.
     * @return A list of reviews with a rating equal to or higher than the specified rating.
     */
    public List<Review> filterReviewByRating(double rating) {
        if(rating <= 0 || rating >= 6) {
            throw new ValidationException("Rating must be between 1 and 5");
        }
        return service.filterReviewByRating(rating);
    }
    /**
     * Sorts the list of reviews by their rating in descending order.
     * The reviews are sorted from the highest rating to the lowest rating.
     */
    public List<Review> sortReviewsByRating() {
        return service.sortReviewsByRating();
    }
    /**
     * Sorts the list of properties by their price in ascending order.
     * The properties are sorted from the lowest price to the highest price.
     */
    public List<Property> sortPropertiesByPrice() {
       return service.sortPropertiesByPrice();
    }

    public List<Property> getPropertiesByAgentId(int agentId) {
        if(agentId <= 0){
            throw new ValidationException("Agent ID must be greater than 0");
        }
        return service.getPropertiesByAgentId(agentId);
    }
    public List<Property> getUnvisitedProperties(){
        return service.viewUnvisitedProperties();
    }
}
