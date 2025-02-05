package org.example.Service;
import org.example.Model.*;
import org.example.Repository.*;
import java.util.*;
import java.util.stream.Collectors;
import org.example.Exceptions.EntityNotFoundException;
import org.example.Exceptions.ValidationException;
import org.example.Exceptions.BusinessLogicException;
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
        try {
            if (appointment.getId() == null || appointment.getId() == 0) {
                throw new BusinessLogicException("ID cannot be null or 0");
            }
            appointmentRepository.create(appointment);
            markPropertyIsSeenByClient(appointment);
        }catch(BusinessLogicException e) {
            System.out.println("Error while creating appointment"+e.getMessage());
        }
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
    public void updateReview(Review review){reviewRepository.update(review);}

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
    public Review getReviewById(int reviewId){return reviewRepository.read(reviewId);}
    /**
     * Retrieves a client object from the system based on the provided ID.
     *
     * @param clientID The ID of the client to retrieve.
     * @return The Client object with the matching ID, or null if not found.
     */
    public Client getClientById(Integer clientID) {
        try{
           if(clientID == null){
               throw new IllegalArgumentException("Client ID cannot be null");
           }
           Client client = clientRepository.read(clientID);
           if(client == null){
               throw new EntityNotFoundException("Client not found");
           }
           return client;
        }catch (IllegalArgumentException | EntityNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
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
    /**
     * Retrieves all reviews related to a specific property.
     *
     * @param propertyId The ID of the property.
     * @return A list of Review objects associated with the specified property.
     */
    public List<Review> getReviewsByProperty(int propertyId) {
        return getAllReviews().stream()
                .filter(review -> "property".equals(review.getType()) && review.getPropertyID() != null && review.getPropertyID().equals(propertyId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all reviews related to a specific agent.
     *
     * @param agentId The ID of the agent.
     * @return A list of Review objects associated with the specified agent.
     */
    public List<Review> getReviewsByAgent(int agentId) {
        return getAllReviews().stream()
                .filter(review -> "agent".equals(review.getType()) && review.getAgentID() != null && review.getAgentID().equals(agentId))
                .collect(Collectors.toList());
    }
    /**
     * Links a property to an agent, marking that the agent is associated with
     * the property.
     *
     * @param propertyId The ID of the property.
     * @param agentId    The ID of the agent.
     */
    public void linkPropertyAndAgent(int agentId, int propertyId) {
        try {
            Agent agent = getAgentById(agentId);

            Property property = getPropertyById(propertyId);
            if (agent != null && property != null) {
                if (agent.getAssignedProperties() == null) {
                    agent.setAssignedProperties(new ArrayList<>());
                }
                agent.getAssignedProperties().add(property);
            } else {
                throw new EntityNotFoundException("Agent or property not found.");
            }
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Displays all properties that have not been visited by any clients.
     */
    public List<Property> viewUnvisitedProperties() {
        List<Property> allProperties = getAllProperties();
        List<Appointment> allAppointments = getAllAppointments();
        Set<Integer> visitedPropertyIds = allAppointments.stream().map(Appointment::getPropertyID).collect(Collectors.toSet());
        return allProperties.stream().filter(property -> !visitedPropertyIds.contains(property.getId())).collect(Collectors.toList());
    }
//    public List<Property> viewUnvisitedProperties() {
//        List<Client> allClients=getAllClients();
//        List<Property> properties=getAllProperties();
//        List<Property> unvisitedProperties=new ArrayList<>();
//        Set<Property> visitedProperties=new HashSet<>();
//        for(Property property:properties){
//            if(property.getSeenByClient()!=null){
//                visitedProperties.add(property);
//            }
//        }
//        for(Client client:allClients){
//            if(client.getSeeProperty()!=null){
//                visitedProperties.addAll(client.getSeeProperty());
//            }
//        }
//        for (Property property : properties) {
//            if (!visitedProperties.contains(property)) {
//                unvisitedProperties.add(property);
//            }
//        }
//
//        return unvisitedProperties;
//    }
    /**
     * Recommends properties for a client based on their preferences.
     *
     * @param ClientID The ID of the client.
     */
    public List<Property> recommendPropertiesForClient(Integer ClientID) {
        try {
            Client client = getClientById(ClientID);
            ClientPreferences preferences = getClientPreferencesByClientId(ClientID);
            List<Property> allProperties = getAllProperties();
            List<Property> recommendedProperties = new ArrayList<>();

            if (client == null) {
                throw new EntityNotFoundException("Client with ID " + ClientID + " not found.");
            }
            if (preferences == null) {
                throw new ValidationException("Client with ID " + ClientID + " does not have any preferences set.");
            }

            for (Property property : allProperties) {
                if (preferences.matchesPreferences(property)) {
                    recommendedProperties.add(property);
                }
            }

            if (recommendedProperties.isEmpty()) {
                throw new BusinessLogicException("No properties found that match the client's preferences.");
            }
            return recommendedProperties;
        } catch (EntityNotFoundException | ValidationException | BusinessLogicException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>(); // Return empty list in case of exceptions
        }
    }
    /**
     * Analyzes an agent's performance based on reviews and contracts.
     *
     * @param AgentID The ID of the agent.
     */
    public void analyzeAgentPerformance(Integer AgentID){
        try{
        List<Review> reviews = getAllReviews();
        List<Contract> contracts = getAllContracts();
        Agent agent = getAgentById(AgentID);
        if (agent == null) {
            throw new EntityNotFoundException("Agent with ID " + AgentID + " not found.");
        }
        double totalRating = 0;
        int ratingCount = 0;
        for (Review review : reviews){
            if (review.getAgentID() != null && Objects.equals(review.getAgentID(), AgentID)) {
                totalRating += review.getRating();
                ratingCount++;
            }else if (review.getPropertyID() != null){
                    Property property = getPropertyById(review.getPropertyID());
                    if (property!=null && property.getAgentID()!=null && Objects.equals(property.getAgentID(),AgentID)) {
                        totalRating += review.getRating();
                        ratingCount++;
                    }
            }
        }
        double averageRating = (ratingCount > 0) ? totalRating / ratingCount : 0;

        int contractCount = 0;
        double profitMade = 0;
        Map<String, Integer> locationStr = new HashMap<>();
        Set<Integer> allocatedPropertyIds = new HashSet<>();
        Set<Integer> soldPropertyIds = new HashSet<>();
        for (Contract contract : contracts) {
            Property property = getPropertyById(contract.getPropertyID());
            if (property != null && Objects.equals(property.getAgentID(), AgentID)) {
                contractCount++;
                if (property.getLocation() != null){
                    allocatedPropertyIds.add(property.getId());
                    soldPropertyIds.add(property.getId());
                    String location = property.getLocation();
                    locationStr.put(location, locationStr.getOrDefault(location, 0) + 1);
                    if(property.getPrice()>=5000){
                        profitMade = profitMade + property.getPrice() * 0.03;
                    }
                }
            }
        }
        List<Property> allProperties = getAllProperties();
        for (Property property : allProperties) {
            if (Objects.equals(property.getAgentID(), AgentID)) {
                allocatedPropertyIds.add(property.getId());
            }
        }
        double percentage = (allocatedPropertyIds.isEmpty()) ? 0 : (double) soldPropertyIds.size() / allocatedPropertyIds.size() * 100;
        int soldPropertiesPercentage = (int) percentage;
        String mostFrequentLocation = locationStr.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No specific location");

        System.out.println("Average Rating: " + averageRating + " stars");
        System.out.println("Number of Contracts: " + contractCount);
        System.out.println("The place where the agent has the most contracts: " + mostFrequentLocation );
        System.out.println("Profit made by the agent in EUR: " + profitMade);
        System.out.println("Percentage of properties sold out of those allocated to the agent: " + soldPropertiesPercentage + "%");

        if (averageRating >= 4.5 && contractCount >= 10) {
            System.out.println("This agent is performing excellently! Nothing more to ask.");
        } else if (averageRating >= 3.5) {
            System.out.println("This agent is performing quite well.");
            System.out.println("Tip: If the rating average increases a bit or a few more contracts will be concluded, the agent will excel.");

        } else {
            throw new BusinessLogicException("This agent needs improvement. More contracts or better reviews are needed.");
        }
        }catch (EntityNotFoundException | BusinessLogicException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Checks if a property is currently under contract.
     *
     * @param propertyID The ID of the property.
     * @return true if the property is under contract; false otherwise.
     * @throws EntityNotFoundException if the property is not found.
     */
    public boolean isPropertyUnderContract(int propertyID) {
        try {
            Property property = getPropertyById(propertyID);
            if (property == null) {
                throw new EntityNotFoundException("Property with ID " + propertyID + " not found.");
            }
            List<Contract> contracts = getAllContracts();
            for (Contract contract : contracts) {
                if (contract.getPropertyID() == propertyID) {
                    return true;
                }
            }
            return false;
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    /**
     * Sorts the list of properties by their price in ascending order.
     * The properties are sorted from the lowest price to the highest price.
     * @throws BusinessLogicException if no properties are found.
     */
    public List<Property> sortPropertiesByPrice() {
        try{
        List<Property> properties = getAllProperties();
        if (properties.isEmpty()) {
            throw new BusinessLogicException("No properties found to sort.");
        }
        properties.sort(Comparator.comparingDouble(Property::getPrice));
        return properties;
        }catch (BusinessLogicException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    /**
     * Sorts the list of reviews by their rating in descending order.
     * The reviews are sorted from the highest rating to the lowest rating.
     * @throws BusinessLogicException if no reviews are found.
     */
    public List<Review> sortReviewsByRating() {
        try{
        List<Review> reviews = getAllReviews();
        if (reviews.isEmpty()) {
            throw new BusinessLogicException("No reviews found to sort.");
        }
        reviews.sort((r1, r2) -> Double.compare(r2.getRating(), r1.getRating()));
        return reviews;
        }catch (BusinessLogicException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    /**
     * Filters a list of properties by their price range.
     * Only properties with a price between the specified minPrice and maxPrice (inclusive) will be included in the result.
     *
     * @param minPrice The minimum price a property can have to be included in the filtered list.
     * @param maxPrice The maximum price a property can have to be included in the filtered list.
     * @return A list of properties whose prices fall within the specified range.
     * @throws ValidationException if minPrice is greater than maxPrice.
     * @throws BusinessLogicException if no properties are found within the specified range.
     */
    public List<Property> filterPropertyByPrice(int minPrice, int maxPrice) {
        try {
            if (minPrice > maxPrice) {
                throw new ValidationException("Minimum price cannot be greater than maximum price.");
            }
            List<Property> filteredProperties = getAllProperties().stream()
                    .filter(property -> property.getPrice() >= minPrice && property.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
            if (filteredProperties.isEmpty()) {
                throw new BusinessLogicException("No properties found within the specified price range.");
            }
            return filteredProperties;
        }catch (ValidationException | BusinessLogicException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Filters a list of reviews by their rating.
     * Only reviews with a rating greater than or equal to the specified minRating will be included in the result.
     *
     * @param minRating The minimum rating a review can have to be included in the filtered list.
     * @return A list of reviews with a rating greater than or equal to minRating.
     * @throws ValidationException if minRating is less than 0 or greater than 5.
     * @throws BusinessLogicException if no reviews are found with the specified rating.
     */
    public List<Review> filterReviewByRating(double minRating) {
        try{
        if (minRating < 0 || minRating > 5) {
            throw new ValidationException("Rating must be between 0 and 5.");
        }
        List<Review> filteredReviews = getAllReviews().stream()
                .filter(review -> review.getRating() >= minRating)
                .collect(Collectors.toList());
        if (filteredReviews.isEmpty()) {
            throw new BusinessLogicException("No reviews found with the specified rating.");
        }
        return filteredReviews;
        }catch (ValidationException | BusinessLogicException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    /**
     * Retrieves a list of properties assigned to a specific agent.
     *
     * @param agentId The ID of the agent.
     * @return A list of Property objects assigned to the agent.
     * @throws EntityNotFoundException if the agent is not found.
     * @throws BusinessLogicException if no properties are found for the specified agent.
     */
    public List<Property> getPropertiesByAgentId(int agentId) {
        try {
            Agent agent = getAgentById(agentId);
            if (agent == null) {
                throw new EntityNotFoundException("Agent with ID " + agentId + " not found.");
            }
            List<Property> properties = getAllProperties().stream()
                    .filter(property -> property.getAgentID() == agentId)
                    .collect(Collectors.toList());
            if (properties.isEmpty()) {
                throw new BusinessLogicException("No properties found for agent ID " + agentId);
            }
            return properties;
        }catch (EntityNotFoundException | BusinessLogicException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    /**
     * Marks a property as seen by a client based on the provided appointment details.
     * This method updates both the property and the client to reflect that the property has been seen by the client.
     *
     * @param appointment The Appointment object containing the details of the property and client.
     * @throws EntityNotFoundException if the property or client is not found.
     */
    public void markPropertyIsSeenByClient(Appointment appointment) {
            try{
                Property property= getPropertyById(appointment.getPropertyID());
                if (property == null) {
                    throw new EntityNotFoundException("Property with ID " + appointment.getPropertyID() + " not found.");
                }
                Integer clientId = appointment.getClientID();
                Client client = getClientById(clientId);
                if(client==null){
                    throw new EntityNotFoundException("Client with ID " + clientId + " not found.");
                }
                if(property.getSeenByClient()==null){
                    property.setSeenByClient(new ArrayList<>());
                }
                if(client.getSeeProperty()==null){
                    client.setSeeProperty(new ArrayList<>());
                }
                if(!property.getSeenByClient().contains(client)){
                    property.getSeenByClient().add(client);
                }
                if(!client.getSeeProperty().contains(property)){
                    client.getSeeProperty().add(property);
                }
            }
            catch(Exception e){
                System.out.println("Error while marking property as seen: " + e.getMessage());
            }
    }
    public List<Property> retrievePropertiesUnvisited(){
        try{
            List<Property> properties = getAllProperties();
            List<Property> unvisitedProperties = new ArrayList<>();
            for(Property property : properties){
                if(property.getSeenByClient()==null || property.getSeenByClient().isEmpty()){
                    unvisitedProperties.add(property);
                }
            }
            return unvisitedProperties;
        }
        catch (Exception e) {
            System.out.println("An error occurred while retrieving unvisited properties: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
