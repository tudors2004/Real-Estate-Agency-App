package Model;
import java.io.Serializable;
/**
 * Represents an entity with a unique identifier.
 * This interface extends Serializable and is a functional interface.
 */
@FunctionalInterface
public interface HasID extends Serializable {
    /**
     * Gets the unique identifier of the entity.
     *
     * @return The unique identifier of the entity.
     */
    Integer getId();
}