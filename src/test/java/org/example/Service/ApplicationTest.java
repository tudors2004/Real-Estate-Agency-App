package org.example.Service;
import org.example.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Repository.*;

class ApplicationTest {
    private Service service;

    @BeforeEach
    void setUp() {
        IRepository<Agent> agentRepo = new InMemoryRepository<>();
        IRepository<Property> propertyRepo = new InMemoryRepository<>();
        IRepository<Contract> contractRepo = new InMemoryRepository<>();
        IRepository<Appointment> appointmentRepo = new InMemoryRepository<>();
        IRepository<Client> clientRepo = new InMemoryRepository<>();
        IRepository<Review> reviewRepo = new InMemoryRepository<>();
        IRepository<ClientPreferences> preferencesRepo = new InMemoryRepository<>();
        service = new Service(agentRepo, propertyRepo, contractRepo, appointmentRepo, clientRepo, reviewRepo, preferencesRepo);
    }

    @Test
    public void testAllCRUDOperations(){
        Agent agent = new Agent(1, "Tudor", 123456789, "tudor@yahoo.com",  1000);
        service.addAgent(agent);
        List<Agent> agents = service.getAllAgents();
        assertEquals(1, agents.size());
        assertEquals("Tudor", agents.getFirst().getName());
        agent.setName("TudorBoss");
        service.updateAgent(agent);
        Agent updatedAgent = service.getAgentById(1);
        assertNotNull(updatedAgent);
        assertEquals("TudorBoss", updatedAgent.getName());
        service.deleteAgent(1);
        assertTrue(service.getAllAgents().isEmpty());

        Property property = new Property(1, Property.PropertyType.SPECIAL, "Romania, Bucharest", 200000, 2002, 4, Property.PropertyStatus.RENTED, 100, "Beautiful hall", 1);
        service.addProperty(property);
        List<Property> properties = service.getAllProperties();
        assertEquals(1, properties.size());
        assertEquals("Romania, Bucharest", properties.getFirst().getLocation());
        property.setLocation("Romania, Cluj");
        service.updateProperty(property);
        Property updatedProperty = service.getPropertyById(1);
        assertNotNull(updatedProperty);
        assertEquals("Romania, Cluj", updatedProperty.getLocation());
        service.deleteProperty(1);
        assertTrue(service.getAllProperties().isEmpty());


        Client client = new Client(1, "Andrei", 123456789, "andrei@gmail.com", Client.ClientType.BUYER);
        service.addClient(client);
        List<Client> clients = service.getAllClients();
        assertEquals(1, clients.size());
        assertEquals("Andrei", clients.getFirst().getName());
        client.setName("Mihai");
        service.updateClient(client);
        Client updatedClient = service.getClientById(1);
        assertNotNull(updatedClient);
        service.deleteClient(1);
        assertTrue(service.getAllClients().isEmpty());

        ClientPreferences client_preferences = new ClientPreferences(client, 300000, "Romania, Bucharest", Property.PropertyType.SPECIAL, Property.PropertyStatus.RENTED, 2002, 100, 4);
        service.addClientPreferences(client_preferences);
        List<ClientPreferences> preferences = service.getAllClientPreferences();
        assertEquals(1, preferences.size());
        assertEquals("Romania, Bucharest", preferences.getFirst().getLocation());
        client_preferences.setLocation("Romania, Cluj");
        service.updateClientPreferences(client_preferences);
        ClientPreferences updatedClientPreferences=service.getClientPreferencesByClientId(1);
        assertNotNull(updatedClientPreferences);



        Contract contract = new Contract(1, Contract.ContractType.RENTAL, 12, 1, 1 );
        service.addContract(contract);
        List<Contract> contracts = service.getAllContracts();
        assertEquals(1, contracts.size());
        assertEquals(12,contract.getDuration());
        contract.setDuration(10);
        service.updateContract(contract);
        Contract updatedContract=service.getContractById(1);
        assertNotNull(updatedContract);
        assertEquals(10,updatedContract.getDuration());
        service.deleteContract(1);
        assertTrue(service.getAllContracts().isEmpty());

        Appointment appointment = new Appointment(1, java.sql.Date.valueOf("2025-01-01"), 1, 1);
        service.addAppointment(appointment);
        List<Appointment> appointments = service.getAllAppointments();
        assertEquals(1, appointments.size());
        assertEquals(java.sql.Date.valueOf("2025-01-01"), appointments.getFirst().getDate());
        appointment.setDate(java.sql.Date.valueOf("2025-05-01"));
        service.updateAppointment(appointment);
        Appointment updatedAppointment=service.getAppointmentById(1);
        assertNotNull(updatedAppointment);
        assertEquals(java.sql.Date.valueOf("2025-05-01"), updatedAppointment.getDate());
        service.deleteAppointment(1);
        assertTrue(service.getAllAppointments().isEmpty());

        Review agent_review = new Review(1, 5, 1, "Good agent", 1);
        service.addReview(agent_review);
        List<Review> reviews = service.getAllReviews();
        assertEquals(1, reviews.size());
        assertEquals(5, reviews.getFirst().getRating());
        agent_review.setRating(2);
        service.updateReview(agent_review);
        List<Review> updatedReview=service.getReviewsByAgent(1);
        assertNotNull(updatedReview);
        service.deleteReview(1);
        assertTrue(service.getAllReviews().isEmpty());


        Review property_review= new Review(1, 1, "Price too high for what it offers", 1, 1);
        service.addReview(property_review);
        List<Review> updatedReviews=service.getAllReviews();
        assertEquals(1, updatedReviews.size());
        assertEquals(1,updatedReviews.getFirst().getRating());
        property_review.setRating(3);
        service.updateReview(property_review);
        List<Review> updatedreview=service.getReviewsByProperty(1);
        assertNotNull(updatedreview);
        service.deleteReview(1);
        assertTrue(service.getAllReviews().isEmpty());
    }

    @Test
    public void filterProperties(){
        Property property1 = new Property(1, Property.PropertyType.COMMERCIAL, "Bucuresti,Romania", 1000, 2004, 5, Property.PropertyStatus.AVAILABLE, 100, "Near the Central Park", 1);
        Property property2 = new Property(2, Property.PropertyType.RESIDENTIAL, "Cluj-Napoca,Romania", 2000, 2010, 4, Property.PropertyStatus.RENTED, 150, "Spacious house near university", 2);
        Property property3 = new Property(3, Property.PropertyType.INDUSTRIAL, "Timisoara,Romania", 5000, 2018, 3, Property.PropertyStatus.AVAILABLE, 300, "Factory in industrial zone", 3);

        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);
        List<Property> filteredProperties = service.filterPropertyByPrice(2000, 6000);
        assertEquals(2, filteredProperties.size());
        assertFalse(filteredProperties.stream().allMatch(property ->
                property.getPrice() > 2000 && property.getPrice() < 6000));
        assertEquals(2, filteredProperties.getFirst().getId());
        assertEquals(3, filteredProperties.get(1).getId());
        property2.setPrice(1500);
        service.updateProperty(property2);
        filteredProperties = service.filterPropertyByPrice(2000, 6000);
        assertEquals(1, filteredProperties.size());
        assertEquals(3, filteredProperties.getFirst().getAgentID());
        service.deleteProperty(3);
        filteredProperties = service.filterPropertyByPrice(2000, 6000);
        assertTrue(filteredProperties.isEmpty());
    }
    @Test
    public void linkPropertyandAgent(){
        Agent agent=new Agent(1,"Cornel",4721421,"ioanbudacornel@analfabet.com",123);
        Property property=new Property(1, Property.PropertyType.COMMERCIAL,"Arad,Romania",2000,2014,7,Property.PropertyStatus.AVAILABLE, 110, "In DownTown", 1);
        service.addProperty(property);
        service.addAgent(agent);
        service.linkPropertyAndAgent(1,1);
        Agent linkedAgent=service.getAgentById(1);
        assertNotNull(linkedAgent.getAssignedProperties());
        assertEquals(1, linkedAgent.getAssignedProperties().size());
        assertEquals(property,linkedAgent.getAssignedProperties().getFirst());
    }

    @Test
    public void recommendedPropertiesforClient() {
        Client client = new Client(1,"Alice Smith",331231,"alicesmith@gmail.com",Client.ClientType.BUYER);
        ClientPreferences preferences = new ClientPreferences(client,7000,"Cluj", Property.PropertyType.COMMERCIAL, Property.PropertyStatus.AVAILABLE,2018,200,5);
        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Bucuresti", 3000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 2);
        Property property2 = new Property(2, Property.PropertyType.COMMERCIAL, "Cluj", 7000, 2018, 5, Property.PropertyStatus.AVAILABLE, 200, "Central area", 3);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Brasov", 4500, 2015, 4, Property.PropertyStatus.AVAILABLE, 140, "Mountain view", 4);

        service.addClient(client);
        service.addClientPreferences(preferences);
        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);


        service.recommendPropertiesForClient(1);

        List<Property> recommendedProperties = service.recommendPropertiesForClient(1);
        assertNotNull(recommendedProperties);
        assertEquals(1, recommendedProperties.size());
        assertFalse(recommendedProperties.contains(property1));
        assertFalse(recommendedProperties.contains(property3));
        assertTrue(recommendedProperties.contains(property2));
    }
//    @Test
//    public void testRecommendPropertiesForClient_ClientNotFound() {
//        IRepository<Client> clientRepo=mock(IRepository.class);
//        when(clientRepo.read(999)).thenReturn(null);
//        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
//            service.recommendPropertiesForClient(999);
//        });
//        assertEquals("Client with ID 999 not found.", exception.getMessage());
//    }


    @Test
    public void testIsPropertyUnderContract(){
        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Bucuresti", 3000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 1);
        Property property2 = new Property(2, Property.PropertyType.COMMERCIAL, "Cluj", 7000, 2018, 5, Property.PropertyStatus.AVAILABLE, 200, "Central area", 2);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Iasi", 5000, 2021, 4, Property.PropertyStatus.AVAILABLE, 150, "Near university", 3);
        Client client=new Client(1,"Mihai",231321,"mihaicopaciu@gmail.com",Client.ClientType.BUYER);
        Agent agent=new Agent(1,"Alexandru",3123131,"alexmihai@yahoo.com",12);
        service.addClient(client);
        service.addAgent(agent);
        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);
        Contract contract1 = new Contract(1, Contract.ContractType.PURCHASE,10,1,1);
        service.addContract(contract1);
        boolean result= service.isPropertyUnderContract(1);
        assertTrue(result);
    }
    @Test
    public void testIsNotUnderContract(){
        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Bucuresti", 3000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 1);
        Property property2 = new Property(2, Property.PropertyType.COMMERCIAL, "Cluj", 7000, 2018, 5, Property.PropertyStatus.AVAILABLE, 200, "Central area", 2);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Iasi", 5000, 2021, 4, Property.PropertyStatus.AVAILABLE, 150, "Near university", 3);
        Client client=new Client(1,"Mihai",231321,"mihaicopaciu@gmail.com",Client.ClientType.BUYER);
        Agent agent=new Agent(1,"Alexandru",3123131,"alexmihai@yahoo.com",12);
        service.addClient(client);
        service.addAgent(agent);
        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);
        Contract contract1 = new Contract(1, Contract.ContractType.PURCHASE,10,1,1);
        service.addContract(contract1);
        boolean result=service.isPropertyUnderContract(2);
        assertFalse(result);
    }
    @Test
    public void testSortProperties() {
        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Bucuresti", 3000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 1);
        Property property2 = new Property(2, Property.PropertyType.COMMERCIAL, "Cluj", 7000, 2018, 5, Property.PropertyStatus.AVAILABLE, 200, "Central area", 2);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Iasi", 5000, 2021, 4, Property.PropertyStatus.AVAILABLE, 150, "Near university", 3);

        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);

        List<Property> sortedProperties = service.sortPropertiesByPrice();

        assertEquals(3, sortedProperties.size());
        assertEquals(3000, sortedProperties.get(0).getPrice());
        assertEquals(5000, sortedProperties.get(1).getPrice());
        assertEquals(7000, sortedProperties.get(2).getPrice());


    }

    @Test
    public void testSortReviewsByRating(){
        Review review1 = new Review(1, 1, "Great property", 5, 1);
        Review review2 = new Review(2, 4, "Good value for money", 3, 2);
        Review review3 = new Review(3, 2, "Not as expected", 2, 1);

        service.addReview(review1);
        service.addReview(review2);
        service.addReview(review3);

        List<Review> sortedReviews = service.sortReviewsByRating();
        assertEquals(3, sortedReviews.size());
        assertEquals(review2, sortedReviews.get(0));
        assertEquals(review3, sortedReviews.get(1));
        assertEquals(review1, sortedReviews.get(2));
        assertEquals(1, sortedReviews.get(2).getRating());
    }

    @Test
   public void testFilterPropertyByPrice() {
        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Bucuresti", 2000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 1);
        Property property2 = new Property(2, Property.PropertyType.COMMERCIAL, "Cluj", 5000, 2018, 5, Property.PropertyStatus.AVAILABLE, 200, "Central area", 2);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Brasov", 4500, 2015, 4, Property.PropertyStatus.AVAILABLE, 140, "Mountain view", 3);
        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);

        List<Property> filteredProperties = service.filterPropertyByPrice(3000, 5000);

        assertEquals(2, filteredProperties.size());
        assertTrue(filteredProperties.contains(service.getPropertyById(3)));
        assertTrue(filteredProperties.contains(service.getPropertyById(2)));
    }

    @Test
    public void testFilterReviewByRating(){
        Review review1 = new Review(1, 4, "Great property", 1, 1);
        Review review2 = new Review(2, 3, "Good, but could improve", 1, 2);
        Review review3 = new Review(3, 5, "Excellent, highly recommend", 2, 3);

        service.addReview(review1);
        service.addReview(review2);
        service.addReview(review3);
        List<Review> filteredReviews = service.filterReviewByRating(4);
        assertEquals(2, filteredReviews.size());
        assertTrue(filteredReviews.contains(service.getReviewById(1)));
        assertTrue(filteredReviews.contains(service.getReviewById(3)));
        assertFalse(filteredReviews.contains(service.getReviewById(2)));
    }

    @Test
    public void testGetPropertiesByAgentID(){
        Agent agent1=new Agent(1,"Alexandra",414311,"alexandraenescu@gmail.com",14);
        Agent agent2=new Agent(2,"Mihaela",414131,"mihaelaenescu@gmail.com",12);

        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Cluj", 1000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 1);
        Property property2 = new Property(2, Property.PropertyType.COMMERCIAL, "Bucharest", 2000, 2021, 5, Property.PropertyStatus.AVAILABLE, 200, "Central area", 1);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Brasov", 1500, 2019, 4, Property.PropertyStatus.AVAILABLE, 140, "Mountain view", 2);

        service.addAgent(agent1);
        service.addAgent(agent2);
        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);

        List<Property> properties = service.getPropertiesByAgentId(1);
        assertEquals(2, properties.size());
        assertTrue(properties.contains(service.getPropertyById(1)));
        assertTrue(properties.contains(service.getPropertyById(2)));
    }

    @Test
    public void testAnalyzeAgentPerformance(){
        Agent agent1 = new Agent(1,"Horatiu",321321,"horatiumalaele@gmail.com",1);
        Agent agent2 = new Agent(2, "Eugen",2113211,"eugenionescu@gmail.com",2);

        Property property1 = new Property(1, Property.PropertyType.RESIDENTIAL, "Cluj", 1000, 2020, 4, Property.PropertyStatus.AVAILABLE, 120, "Near park", 1);
        Property property2 = new Property(2, Property.PropertyType.RESIDENTIAL, "Bucharest", 1500, 2021, 5, Property.PropertyStatus.AVAILABLE, 100, "Near shopping mall", 1);
        Property property3 = new Property(3, Property.PropertyType.RESIDENTIAL, "Brasov", 1200, 2020, 3, Property.PropertyStatus.AVAILABLE, 140, "Mountain view", 2);

        service.addAgent(agent1);
        service.addAgent(agent2);
        service.addProperty(property1);
        service.addProperty(property2);
        service.addProperty(property3);

        Review review1 = new Review(1, 1, "Great agent", 1, 1);
        Review review2 = new Review(2, 2, "Good agent", 3, 1);
        Review review3 = new Review(3, 1, "Needs improvement", 2, 2);

        service.addReview(review1);
        service.addReview(review2);
        service.addReview(review3);

        Contract contract1 = new Contract(1, Contract.ContractType.PURCHASE,10,1,1);
        Contract contract2 = new Contract(2, Contract.ContractType.PURCHASE,12,1,2);
        Contract contract3 = new Contract(3,Contract.ContractType.PURCHASE,6,1,3);

        service.addContract(contract1);
        service.addContract(contract2);
        service.addContract(contract3);
        List<Contract> contracts=service.getAllContracts();
        service.analyzeAgentPerformance(1);

    }
}