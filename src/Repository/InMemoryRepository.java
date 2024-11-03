package Repository;
import java.util.HashMap;
import java.util.Map;
import Model.HasID;

public class InMemoryRepository<T extends HasID> implements IRepository<T> {
    private final Map<Integer, T> storage = new HashMap<>();
    @Override
    public void create(T obj) {storage.putIfAbsent(obj.getId(), obj);}
    @Override
    public void update(T obj) {storage.replace(obj.getId(), obj);}
    @Override
    public void delete(int id) {storage.remove(id);}
    @Override
    public T read(int id) {return storage.get(id);}
}
