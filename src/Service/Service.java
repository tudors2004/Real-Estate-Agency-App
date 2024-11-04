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

    public Service(IRepository<Agent> agent, IRepository<Property> property, IRepository<Contract> contract, IRepository<Appointment> appointment, IRepository<Client> client) {
        this.agentRepository = agent;
        this.propertyRepository = property;
        this.contractRepository = contract;
        this.appointmentRepository = appointment;
        this.clientRepository = client;
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
}
