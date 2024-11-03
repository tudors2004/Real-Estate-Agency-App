package Repository;

public class FileRepository<T> implements IRepository<T> {
//    private int id = 0;
//    private T obj;

    public int create(T obj) {
//        this.obj = obj;
//        return id++;
    }

    public void update(T obj) {
//        this.obj = obj;
    }

    public void delete(int id) {
//        this.obj = null;
    }

    public T read(int id) {
//        return obj;
    }
}
