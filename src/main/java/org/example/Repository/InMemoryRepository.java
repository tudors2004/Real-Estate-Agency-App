package org.example.Repository;
import java.util.HashMap;
import java.util.Map;
import org.example.Model.HasID;
import java.util.List;
import java.util.ArrayList;
/**
 * In-memory implementation of the IRepository interface, using a HashMap to
 * store and manage entities. This repository stores entities that implement the
 * HasID interface to guarantee each entity has a unique ID.
 *
 * @param <T> The type of objects to store in the repository, which must implement
 *           the HasID interface.
 */
public class InMemoryRepository<T extends HasID> implements IRepository<T> {
    private final Map<Integer, T> storage = new HashMap<>();
    /**
     * Creates a new object in the repository if it does not already exist.
     *
     * @param obj The object to be created.
     */
    @Override
    public void create(T obj) {
        storage.putIfAbsent(obj.getId(), obj);
    }
    /**
     * Updates an existing object in the repository.
     *
     * @param obj The object to be updated.
     */
    @Override
    public void update(T obj) {
        storage.replace(obj.getId(), obj);
    }
    /**
     * Deletes an object from the repository.
     *
     * @param id The ID of the object to delete.
     */
    @Override
    public void delete(Integer id) {
        storage.remove(id);
    }
    /**
     * Reads an object from the repository.
     *
     * @param id The ID of the object to read.
     * @return The object with the given ID, or null if no such object exists.
     */
    @Override
    public T read(Integer id) {
        return storage.get(id);
    }
    /**
     * Gets all objects from the repository.
     *
     * @return A list containing all objects in the repository.
     */
    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }
}