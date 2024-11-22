package org.example.Repository;
import org.example.Model.*;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FileRepository<T extends HasID> implements IRepository<T> {
    private final String filePath;
    private final Class<T> type;

    public FileRepository(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }

    @Override
    public void create(T obj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(obj.toCsv());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    @Override
    public void update(T obj) {
        List<T> objects = getAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T o : objects) {
                if (o.getId().equals(obj.getId())) {
                    writer.write(obj.toCsv());
                } else {
                    writer.write(o.toCsv());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    @Override
    public void delete(Integer id) {
        List<T> objects = getAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T o : objects) {
                if (!o.getId().equals(id)) {
                    writer.write(o.toCsv());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    @Override
    public T read(Integer id) {
        List<T> objects = getAll();
        for (T o : objects) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> objects = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                objects.add(convertFromCsv(line, getClassType()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
        return objects;
    }

    public T convertFromCsv(String csv, Class<T> type) {
        String[] values = csv.split(",");
        try {
            T obj = type.getConstructor().newInstance();
            if (type == Contract.class) {
                ((Contract) obj).setId(Integer.parseInt(values[0]));
                ((Contract) obj).setType(Contract.ContractType.valueOf(values[1]));
                ((Contract) obj).setDuration(Integer.parseInt(values[2]));
                ((Contract) obj).setAgentID(Integer.parseInt(values[3]));
                ((Contract) obj).setClientID(Integer.parseInt(values[4]));
                ((Contract) obj).setPropertyID(Integer.parseInt(values[5]));
            } else if (type == ClientPreferences.class) {
                ((ClientPreferences) obj).setId(Integer.parseInt(values[0]));
                ((ClientPreferences) obj).setName(values[1]);
                ((ClientPreferences) obj).setPhoneNumber(Integer.valueOf(values[2]));
                ((ClientPreferences) obj).setEmail(values[3]);
                ((ClientPreferences) obj).setClientType(Client.ClientType.valueOf(values[4]));
                ((ClientPreferences) obj).setBudget(Double.parseDouble(values[5]));
                ((ClientPreferences) obj).setLocation(values[6]);
                ((ClientPreferences) obj).setPreferredType(Property.PropertyType.valueOf(values[7]));
                ((ClientPreferences) obj).setPreferredStatus(Property.PropertyStatus.valueOf(values[8]));
                ((ClientPreferences) obj).setYear(Integer.parseInt(values[9]));
                ((ClientPreferences) obj).setSize(Double.parseDouble(values[10]));
                ((ClientPreferences) obj).setRooms(Integer.parseInt(values[11]));
            } else if (type == Agent.class){
                ((Agent) obj).setId(Integer.parseInt(values[0]));
                ((Agent) obj).setName(values[1]);
                ((Agent) obj).setPhoneNumber(Integer.valueOf(values[2]));
                ((Agent) obj).setEmail(values[3]);
                ((Agent) obj).setLicenseNumber(Integer.valueOf(values[4]));
            } else if (type == Property.class) {
                ((Property) obj).setId(Integer.parseInt(values[0]));
                ((Property) obj).setType(Property.PropertyType.valueOf(values[1]));
                ((Property) obj).setLocation(values[2]);
                ((Property) obj).setPrice(Double.parseDouble(values[3]));
                ((Property) obj).setYear(Integer.parseInt(values[4]));
                ((Property) obj).setRooms(Integer.parseInt(values[5]));
                ((Property) obj).setStatus(Property.PropertyStatus.valueOf(values[6]));
                ((Property) obj).setSize(Double.parseDouble(values[7]));
                ((Property) obj).setDescription(values[8]);
                ((Property) obj).setAgentID(Integer.parseInt(values[9]));
            } else if (type == Appointment.class) {
                ((Appointment) obj).setId(Integer.parseInt(values[0]));
                ((Appointment) obj).setDate(new Date(Long.parseLong(values[1])));
                ((Appointment) obj).setAgentID(Integer.parseInt(values[2]));
                ((Appointment) obj).setClientID(Integer.parseInt(values[3]));
                ((Appointment) obj).setPropertyID(Integer.parseInt(values[4]));
            } else if (type == Client.class) {
                ((Client) obj).setId(Integer.parseInt(values[0]));
                ((Client) obj).setName(values[1]);
                ((Client) obj).setPhoneNumber(Integer.valueOf(values[2]));
                ((Client) obj).setEmail(values[3]);
                ((Client) obj).setClientType(Client.ClientType.valueOf(values[4]));
            } else if (type == Review.class){
                ((Review) obj).setId(Integer.parseInt(values[0]));
                ((Review) obj).setRating(Integer.parseInt(values[1]));
                ((Review) obj).setComment(values[2]);
                ((Review) obj).setAgentID(Integer.parseInt(values[3]));
                ((Review) obj).setClientID(Integer.parseInt(values[4]));
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Error converting CSV to object", e);
        }
    }

    // Helper method to get the class type in case we have a generic object
    private Class<T> getClassType() {
        return type;
    }
}