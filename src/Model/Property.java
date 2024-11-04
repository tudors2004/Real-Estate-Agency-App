package Model;

public class Property implements HasID{
    private Integer id;
    private String type;
    private String address;
    private double price;
    private Integer year;
    private Integer rooms;
    private String status;
    private Integer size;
    private String description;
    private Agent associatedAgent;

    @Override
    public Integer getId() {
        return id;
    }

    public Property(Integer id, String type, String address, double price, Integer year, Integer rooms, String status, Integer size, String description, Agent associatedAgent) {
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

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", rooms=" + rooms +
                ", status='" + status + '\'' +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", associatedAgent=" + associatedAgent +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
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
