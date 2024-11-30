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

        //TODO: restul testelor CRUD

        //    client = new Client(1, "Andrei", 123456789, "andrei@gmail.com", Client.ClientType.BUYER);
        //    client_preferences = new ClientPreferences(client, 300000, "Romania, Bucharest", Property.PropertyType.SPECIAL, Property.PropertyStatus.RENTED, 2002, 100, 4);
        //    contract = new Contract(1, Contract.ContractType.RENTAL, 12, 1, 1, 1 );
        //    appointment = new Appointment(1, java.sql.Date.valueOf("2025-01-01"), 1, 1, 1);
        //    agent_review = new Review(1, 5, 1, "Good agent", 1);
        //    property_review = new Review(1, 1, "Price too high for what it offers", 1, 1);
    }

    //TODO: testele pentru metodele din Service (2 pentru fiecare metoda complexa, 1 pentru metodele simple)
    //A test for normal flow (successful operation).
    //A test that ensures that the correct exception is thrown
}