package Model;
import java.io.Serializable;
@FunctionalInterface
public interface HasID extends Serializable {
    Integer getId();
}