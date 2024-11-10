package Repository;
import java.util.List;
/**
 * Generic interface for repository operations, providing basic CRUD operations
 * for objects of type T.
 *
 * @param <T> The type of objects to store in the repository.
 */
public interface IRepository<T> {
    /**
     * Creates a new object in the repository.
     *
     * @param obj The object to be created.
     */
    void create(T obj);
    /**
     * Updates an existing object in the repository.
     *
     * @param obj The object to be updated.
     */
    void update(T obj);
    /**
     * Deletes an object from the repository.
     *
     * @param id The ID of the object to delete.
     */
    void delete(Integer id);
    /**
     * Reads an object from the repository.
     *
     * @param id The ID of the object to read.
     * @return The object with the given ID, or null if no such object exists.
     */
    T read (Integer id);
    /**
     * Gets all objects from the repository.
     *
     * @return A list containing all objects in the repository.
     */
    List<T> getAll();
}
