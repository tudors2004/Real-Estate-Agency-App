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
}
