package Service;
import Model.*;
import Repository.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Service {
    private final IRepository<Agent> agentRepository;
    private final IRepository<Property> propertyRepository;
    private final IRepository<Contract> contractRepository;
    private final IRepository<Appointment> appointmentRepository;
    private final IRepository<Client> clientRepository;
    private final IRepository<Review> reviewRepository;
    private final IRepository<ClientPreferences> clientPreferencesRepository;
    public Service(IRepository<Agent> agent, IRepository<Property> property, IRepository<Contract> contract, IRepository<Appointment> appointment, IRepository<Client> client, IRepository<Review> review, IRepository<ClientPreferences> clientPreferences) {
        this.agentRepository = agent;
        this.propertyRepository = property;
        this.contractRepository = contract;
        this.appointmentRepository = appointment;
        this.clientRepository = client;
        this.reviewRepository = review;
        this.clientPreferencesRepository = clientPreferences;
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
    public void addClientPreferences(ClientPreferences clientPreferences){
        clientPreferencesRepository.create(clientPreferences);
    }
    public void updateClientPreferences(ClientPreferences clientPreferences){
        clientPreferencesRepository.update(clientPreferences);
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
    public List<ClientPreferences> getAllClientPreferences() {
        return clientPreferencesRepository.getAll();
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
    public ClientPreferences getClientPreferencesByClientId(Integer clientId) {
        return clientPreferencesRepository.read(clientId);
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
        if(unvisitedProperties.isEmpty()){
            System.out.println("No unvisited properties found.");
        }else {
            for (Property property : unvisitedProperties) {
                System.out.println(property);
            }
        }
    }

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

    public void generateActivityReport(){
        System.out.println("--Activity report--\n" +
                "Number of properties: " + getAllProperties().size() + "\n" +
                "Number of contracts: " + getAllContracts().size() + "\n" +
                "Number of appointments: " + getAllAppointments().size() + "\n" +
                "Number of clients: " + getAllClients().size() + "\n" +
                "Number of reviews: " + getAllReviews().size());
    }

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
