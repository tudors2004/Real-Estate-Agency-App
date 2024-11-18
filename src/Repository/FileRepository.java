package Repository;
import java.io.*;
import java.util.*;
import Model.HasID;
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

    /**
     * Constructs a new FileRepository with the specified file name.
     *
     * @param fileName The name of the file used for storing and retrieving data.
     */
    public FileRepository(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Adds a new object to the file. Throws an exception if an object with the same ID already exists.
     *
     * @param obj The object to be added to the file.
     * @throws IllegalArgumentException if an object with the same ID already exists.
     */
    @Override
    public void create(T obj) {
        doInFile(storage->storage.putIfAbsent(obj.getId(),obj));
    }

    /**
     * Updates an existing object in the file. Throws an exception if the object does not exist.
     *
     * @param obj The object with updated information.
     * @throws IllegalArgumentException if the object with the given ID does not exist.
     */
    @Override
    public void update(T obj) {
//        List<T> data = getAll();
//        boolean found = false;
//        for(int i=0; i<data.size(); i++) {
//            if(data.get(i).getId().equals(obj.getId())){
//                data.set(i, obj);
//                found = true;
//                break;
//            }
//        }
//        if(!found){
//            throw new IllegalArgumentException("Object with given ID doesnt exist!!!");
//        }
//        writeToFile(data);
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
//        List<T> data = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                data.add(parseLine(line));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
        return readDataFromFile().values().stream().toList();
    }
    private void doInFile(Consumer<Map<Integer, T>> function) {
        Map<Integer, T> data = readDataFromFile();
        function.accept(data);
        writeDataToFile(data);
    }
    private Map<Integer, T> readDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Map<Integer, T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
    private void writeDataToFile(Map<Integer, T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private T parseLine(String line) {
//       String[] parts = line.split(",");
//         return null;
//         //TODO: Implement this method
//    }
//
//    private void writeToFile(List<T> data) {
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
//            for (T obj : data) {
//                bw.write(obj.toString());
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}