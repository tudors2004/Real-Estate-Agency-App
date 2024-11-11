package Repository;
import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import Model.HasID;
/**
 * FileRepository is a generic repository that manages data storage for entities
 * in a file, with each entity stored on a new line in a comma-separated format.
 * It supports standard CRUD operations and uses a file for persistence.
 *
 * @param <T> The type of objects this repository manages, which must implement HasID.
 */
public class FileRepository<T> implements IRepository<T> {
    private final String fileName;
    /**
     * Constructs a new FileRepository with the specified file name.
     *
     * @param fileName The name of the file used for storing and retrieving data.
     */
    public FileRepository(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void create(T obj) {
        //TODO
    }
    @Override
    public void update(T obj) {
        //TODO
    }
    @Override
    public void delete(Integer id) {
        //TODO
    }
    @Override
    public T read(Integer id) {
        //TODO
        return null;
    }

    @Override
    public List<T> getAll() {
        //TODO
        return List.of();
    }

    //ASTEA NU S BUNE
//    private void doInFile(Consumer<Map<Integer, T>> function) {
//        Map<Integer, T> data = readDataFromFile();
//        function.accept(data);
//        writeDataToFile(data);
//    }
//
//    private Map<Integer, T> readDataFromFile() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
//            return (Map<Integer, T>) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            return new HashMap<>();
//        }
//    }
//    private void writeDataToFile(Map<Integer, T> data) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            oos.writeObject(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
