package Model;

import java.util.List;

public class Property implements HasID{
    private Integer id;
    private PropertyType type;
    private String location;
    private double price;
    private Integer year;
    private Integer rooms;
    private PropertyStatus status;
    private double size;
    private String description;
    private Agent associatedAgent;
    private List<Client> seenByClient;

    @Override
    public Integer getId() {
        return id;
    }

    public Property(Integer id, PropertyType type, String location, double price, Integer year, Integer rooms, PropertyStatus status, double size, String description, Agent associatedAgent) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.price = price;
        this.year = year;
        this.rooms = rooms;
        this.status = status;
        this.size = size;
        this.description = description;
        this.associatedAgent = associatedAgent;
    }

    public enum PropertyType{
        RESIDENTIAL,
        COMMERCIAL,
        INDUSTRIAL,
        SPECIAL
    }

    public enum PropertyStatus{
        AVAILABLE,
        UNDER_CONSTRUCTION,
        RENTED
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price + "€"+
                ", year=" + year +
                ", rooms=" + rooms +
                ", status='" + status + '\'' +
                ", size=" + size + " m^2" +
                ", description='" + description + '\'' +
                ", associatedAgent=" + associatedAgent +
                '}';
    }

    public List<Client> getSeenByClient() {
        return seenByClient;
    }

    public void setSeenByClient(List<Client> seenByClient) {
        this.seenByClient = seenByClient;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public PropertyStatus getStatus() {
        return status;
    }

    public void setStatus(PropertyStatus status) {
        this.status = status;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agent getAssociatedAgent() {
        return associatedAgent;
    }

    public void setAssociatedAgent(Agent associatedAgent) {
        this.associatedAgent = associatedAgent;
    }
}
