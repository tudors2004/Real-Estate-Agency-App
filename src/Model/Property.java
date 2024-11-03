package Model;

public class Property {
    private int id;
    private String type;
    private String address;
    private double price;
    private int year;
    private int rooms;
    private String status;
    private double size;
    private String description;

    public Property(int id, String type, String address, double price, int year, int rooms, String status, double size, String description) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.price = price;
        this.year = year;
        this.rooms = rooms;
        this.status = status;
        this.size = size;
        this.description = description;
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
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}
