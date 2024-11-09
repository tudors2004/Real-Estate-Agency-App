package Repository;
import java.util.List;
public interface IRepository<T> {
    void create(T obj);
    void update(T obj);
    void delete(Integer id);
    T read (Integer id);
    List<T> getAll();
}
