package Repository;

import java.io.*;
import java.util.*;
import Model.HasID;
/**
 * FileRepository is a generic repository that manages data storage for entities
 * in a file, with each entity stored on a new line in a comma-separated format.
 * It supports standard CRUD (Create, Read, Update, Delete) operations and ensures
 * persistence by saving the entities in a specified file.
 *
 * @param <T> The type of objects this repository manages, which must implement the {@link HasID} interface.
 */
public class FileRepository<T extends HasID> implements IRepository<T> {
    private final String fileName;
    private final Class<T> type;
    /**
     * Constructs a new FileRepository instance.
     *
     * @param fileName The name of the file to be used for persistence.
     * @param type     The class type of the objects this repository manages.
     */
    public FileRepository(String fileName, Class<T> type) {
        this.fileName = fileName;
        this.type = type;
    }
    /**
     * Creates a new entity in the repository. The entity is added to the file if its ID is unique.
     *
     * @param obj The entity to be created.
     * @throws IllegalArgumentException If an entity with the same ID already exists.
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
     * Updates an existing entity in the repository. The entity is replaced in the file if it exists.
     *
     * @param obj The updated entity.
     * @throws IllegalArgumentException If no entity with the specified ID exists.
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
     * Deletes an entity from the repository by its ID.
     *
     * @param id The ID of the entity to delete.
     */
    @Override
    public void delete(Integer id) {
        List<T> objects = getAll();
        objects.removeIf(o -> o.getId().equals(id));
        writeToFile(objects);
    }
    /**
     * Reads an entity from the repository by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return The entity with the specified ID, or {@code null} if it does not exist.
     */
    @Override
    public T read(Integer id) {
        return getAll().stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }
    /**
     * Retrieves all entities in the repository.
     *
     * @return A list of all entities stored in the file.
     * @throws RuntimeException If an error occurs while reading from the file.
     */
    @Override
    public List<T> getAll() {
        List<T> objects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                objects.add(parseFromCSV(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + e.getMessage(), e);
        }
        return objects;
    }
    /**
     * Parses an entity from a CSV-formatted string.
     *
     * @param csv The CSV string representing the entity.
     * @return The entity created from the CSV string.
     * @throws RuntimeException If an error occurs while parsing the string.
     */
    private T parseFromCSV(String csv) {
        try {
            String[] parts = csv.split(",");
            return type.getDeclaredConstructor(String[].class).newInstance((Object) parts);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing CSV: " + e.getMessage(), e);
        }
    }
    /**
     * Writes a list of entities to the file, overwriting its contents.
     *
     * @param objects The list of entities to write to the file.
     * @throws RuntimeException If an error occurs while writing to the file.
     */
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
    /**
     * Converts an entity to a CSV-formatted string.
     * <p>
     * Note: The {@code toString()} method of the entity class must output data in a
     * valid CSV format for this repository to function correctly.
     *
     * @param obj The entity to convert to CSV.
     * @return A CSV string representation of the entity.
     */
    private String convertToCSV(T obj) {
        return obj.toString();
    }
}