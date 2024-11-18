package Repository;

import java.io.*;
import java.util.*;
import Model.HasID;
/**
 * FileRepository is a generic repository that manages data storage for entities
 * in a file, with each entity stored on a new line in a comma-separated format.
 * It supports standard CRUD operations and uses a file for persistence.
 *
 * @param <T> The type of objects this repository manages, which must implement HasID.
 */
public class FileRepository<T extends HasID> implements IRepository<T> {
    private final String fileName;
    private final Class<T> type;
    /**
     * Constructs a new FileRepository with the specified file name.
     *
     * @param fileName The name of the file used for storing and retrieving data.
     */
    public FileRepository(String fileName, Class<T> type) {
        this.fileName = fileName;
        this.type = type;
    }
    /**
     * Adds a new object to the file. Throws an exception if an object with the same ID already exists.
     *
     * @param obj The object to be added to the file.
     * @throws IllegalArgumentException if an object with the same ID already exists.
     */
    @Override
    public void create(T obj) {
        List<T> objects = getAll();
        if (objects.stream().anyMatch(o -> o.getId().equals(obj.getId()))) {
            throw new IllegalArgumentException("Object with ID " + obj.getId() + " already exists.");
        }
        objects.add(obj);
        writeToFile(objects);
    }
    /**
     * Updates an existing object in the file. Throws an exception if the object does not exist.
     *
     * @param obj The object with updated information.
     * @throws IllegalArgumentException if the object with the given ID does not exist.
     */
    @Override
    public void update(T obj) {
        List<T> objects = getAll();
        boolean found = false;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getId().equals(obj.getId())) {
                objects.set(i, obj);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Object with ID " + obj.getId() + " not found.");
        }
        writeToFile(objects);
    }
    /**
     * Deletes an object by its ID from the file.
     *
     * @param id The ID of the object to delete.
     */
    @Override
    public void delete(Integer id) {
        List<T> objects = getAll();
        objects.removeIf(o -> o.getId().equals(id));
        writeToFile(objects);
    }
    /**
     * Retrieves an object by its ID from the file.
     *
     * @param id The ID of the object to retrieve.
     * @return The object with the specified ID, or null if it does not exist.
     */
    @Override
    public T read(Integer id) {
        return getAll().stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }
    /**
          * Retrieves all entities from the file.
          *
          * @return A list of all entities stored in the file.
     */
    @Override
    public List<T> getAll() {
        List<T> objects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null){
                objects.add(parseFromCSV(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + e.getMessage(), e);
        }
        return objects;
    }

    private T parseFromCSV(String csv) {
        try {
            String[] parts = csv.split(",");
            return type.getDeclaredConstructor(String[].class).newInstance((Object) parts);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing CSV: " + e.getMessage(), e);
        }
    }

    private void writeToFile(List<T> objects) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (T obj : objects) {
                bw.write(convertToCSV(obj));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + e.getMessage(), e);
        }
    }

    private String convertToCSV(T obj) {
        return obj.toString();
    }
}
