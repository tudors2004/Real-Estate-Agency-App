package Repository;

public interface IRepository<T> {
    int create(T obj);
    void update(T obj);
    void delete(int id);
    T read (int id);
}
