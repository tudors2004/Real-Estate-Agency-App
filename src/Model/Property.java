package Model;

public class Property implements HasID{
    private Integer id;
    private PropertyType type;
    private String address;
    private double price;
    private Integer year;
    private Integer rooms;
    private PropertyStatus status;
    private double size;
    private String description;
    private Agent associatedAgent;

    @Override
    public Integer getId() {
        return id;
    }

    public Property(Integer id, PropertyType type, String address, double price, Integer year, Integer rooms, PropertyStatus status, double size, String description, Agent associatedAgent) {
        this.id = id;
        this.type = type;
        this.address = address;
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
        UNDER_CONTRACT,
        RENTED
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price + "€"+
                ", year=" + year +
                ", rooms=" + rooms +
                ", status='" + status + '\'' +
                ", size=" + size + " m^2" +
                ", description='" + description + '\'' +
                ", associatedAgent=" + associatedAgent +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
