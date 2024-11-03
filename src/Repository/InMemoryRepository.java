package Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<T> implements IRepository<T> {
    private final Map<Integer, T> storage = new HashMap<>();
    private int currentId = 0;

    @Override
    public int create(T obj) {
        int id = currentId++;
        storage.put(id, obj);
        return id;
    }

    @Override
    public void update(T obj) {
        int id = -1;
//        for (Map.Entry<Integer, T> entry : storage.entrySet()) {
//            if (entry.getValue().equals(obj)) {
//                id = entry.getKey();
//                break;
//            }
//        }
        if (id != -1) {
            storage.put(id, obj);
        } else {
            throw new IllegalArgumentException("Object not found");
        }
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public T read(int id) {
        return storage.get(id);
    }
}
