import UI.*;
import Controller.*;
import Model.*;
import Repository.*;
import Service.*;
public class Main {
    public static void main(String[] args) {
        //TODO: De adaugat: are you sure you want to delete this ...?
        //TODO: Modifica Appointment si Agent: scoate List si lasa doar obiectul de tipul respectiv
        //TODO: Adauga Enum in toate clasele pentru tipuri (Proprietate, Contract, etc)
        IRepository<Agent> agentRepository = new InMemoryRepository<>();
        IRepository<Property> propertyRepository = new InMemoryRepository<>();
        IRepository<Contract> contractRepository = new InMemoryRepository<>();
        IRepository<Appointment> appointmentRepository = new InMemoryRepository<>();
        IRepository<Client> clientRepository = new InMemoryRepository<>();
        IRepository<Review> reviewRepository = new InMemoryRepository<>();
        Service service = new Service(agentRepository, propertyRepository, contractRepository, appointmentRepository, clientRepository, reviewRepository);
        Controller controller = new Controller(service);
        UI ui = new UI(controller);
        ui.run();
    }
}

