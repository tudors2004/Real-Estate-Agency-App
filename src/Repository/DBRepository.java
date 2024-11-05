package Repository;

import java.util.List;

public class DBRepository<T> implements IRepository<T> {
    @Override
    public void create(T obj) {
        //TODO: implement create
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
        //TODO: implement read
    }
    @Override
    public List<T> getAll() {
        return null;
    }
}
