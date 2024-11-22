package org.example.Model;
import java.io.Serializable;
/**
 * Represents an entity with a unique identifier.
 * This interface extends Serializable and is a functional interface.
 */
//@FunctionalInterface //TODO: Vezi ce face asta si daca e necesar.
public interface HasID extends Serializable {
    /**
     * Gets the unique identifier of the entity.
     *
     * @return The unique identifier of the entity.
     */
    Integer getId();
    String toCsv();
}