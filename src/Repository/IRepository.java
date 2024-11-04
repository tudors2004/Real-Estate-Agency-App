package Repository;

public interface IRepository<T> {
    void create(T obj);
    void update(T obj);
    void delete(int id);
    T read (int id);
}
