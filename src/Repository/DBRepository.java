package Repository;

public class DBRepository<T> implements IRepository<T> {
    @Override
    public int create(T obj) {
        return 0;
    }

    @Override
    public void update(T obj) {
        //TODO: implement update
    }

    @Override
    public void delete(int id) {
        //TODO: implement delete
    }

    @Override
    public T read(int id) {
        return null;
    }
}
