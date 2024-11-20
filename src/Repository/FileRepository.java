package Repository;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;
import Model.HasID;
import Parsers.LineParser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
/**
 * FileRepository is a generic repository that manages data storage for entities
 * in a file, with each entity stored on a new line in a comma-separated format.
 * It supports standard CRUD operations and uses a file for persistence.
 *
 * @param <T> The type of objects this repository manages, which must implement HasID.
 */
public class FileRepository<T extends HasID> implements IRepository<T> {
    private final String fileName;
    private final LineParser<T> lineParser;


    /**
     * Constructs a new FileRepository with the specified file name.
     *
     * @param fileName The name of the file used for storing and retrieving data.
     */
    public <P extends T>FileRepository(String fileName,LineParser<T> lineParser) {
        this.fileName = fileName;
        this.lineParser = lineParser;
    }

    @Override
    public void create(T obj) {
        doInFile(storage->storage.putIfAbsent(obj.getId(),obj));
    }


    @Override
    public void update(T obj) {
        doInFile(storage->storage.replace(obj.getId(),obj));
    }

    /**
     * Deletes an object by its ID from the file.
     *
     * @param id The ID of the object to delete.
     */
    @Override
    public void delete(Integer id) {
       doInFile(storage->storage.remove(id));
    }

    /**
     * Retrieves an object by its ID from the file.
     *
     * @param id The ID of the object to retrieve.
     * @return The object with the specified ID, or null if it does not exist.
     */
    @Override
    public T read(Integer id) {
        return readDataFromFile().get(id);
    }

    /**
     * Retrieves all entities from the file.
     *
     * @return A list of all entities stored in the file.
     */
    @Override
    public List<T> getAll() {

        return readDataFromFile().values().stream().toList();
    }
    private void doInFile(Consumer<Map<Integer, T>> function) {
        Map<Integer, T> data = readDataFromFile();
        function.accept(data);
        writeDataToFile(data);
    }

    private Map<Integer, T> readDataFromFile() {
        Map<Integer, T> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T obj = lineParser.parse(line);
                if (obj != null) {
                    data.put(obj.getId(), obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    private void writeDataToFile(Map<Integer, T> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T obj : data.values()) {
                writer.write(obj.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}