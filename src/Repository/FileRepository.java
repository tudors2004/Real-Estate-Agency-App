package Repository;
import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import Model.HasID;

public class FileRepository<T> implements IRepository<T> {
    private final String fileName;
    public FileRepository(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void create(T obj) {
        //TODO: implement create
    }
    @Override
    public void update(T obj) {
        doInFile(data -> {
            int id = ((HasID) obj).getId();
            if (data.containsKey(id)) {
                data.put(id, obj);
            } else {
                throw new IllegalArgumentException("Object not found");
            }
        });
    }
    @Override
    public void delete(Integer id) {
        doInFile(data -> data.remove(id));
    }
    @Override
    public T read(Integer id) {
        return readDataFromFile().get(id);
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
    @Override
    public List<T> getAll() {
        return new ArrayList<>(readDataFromFile().values());
    }
}
