package Model;
import java.time.LocalDate;
import java.util.List;
/**
 * Represents a property in the real estate agency, implementing the HasID interface.
 */
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
    private LocalDate listDate;
    private LocalDate soldDate;

    /**
     * Gets the unique identifier of the property.
     * @return The unique identifier of the property.
     */
    @Override
    public Integer getId() {
        return id;
    }
    /**
     * Constructs a Property object with the specified ID, type, location, price, year, rooms, status, size, description, and associated agent.
     *
     * @param id              The unique identifier of the property.
     * @param type            The type of the property.
     * @param location        The location of the property.
     * @param price           The price of the property.
     * @param year            The year the property was built.
     * @param rooms           The number of rooms in the property.
     * @param status          The status of the property.
     * @param size            The size of the property.
     * @param description     The description of the property.
     * @param associatedAgent The agent associated with the property.
     */
    public Property(Integer id, PropertyType type, String location, double price, Integer year, Integer rooms, PropertyStatus status, double size, String description, Agent associatedAgent) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
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
    /**
     * Constructs a Property object from a CSV array.
     *
     * @param data An array of strings containing the property's ID, type, location, price, year, rooms, status, size, description, and associated agent ID.
     * @param associatedAgent The agent associated with the property.
     */
    public Property(String[] data, Agent associatedAgent){
        this.id = Integer.parseInt(data[0]);
        this.type = PropertyType.valueOf(data[1]);
        this.location = data[2];
        this.price = Double.parseDouble(data[3]);
        this.year = Integer.parseInt(data[4]);
        this.rooms = Integer.parseInt(data[5]);
        this.status = PropertyStatus.valueOf(data[6]);
        this.size = Double.parseDouble(data[7]);
        this.description = data[8];
        this.associatedAgent = null; // TODO: For the moment it stays like this
    }
    /**
     * Enum representing the type of the property.
     */
    public enum PropertyType{
        RESIDENTIAL,
        COMMERCIAL,
        INDUSTRIAL,
        SPECIAL
    }
    /**
     * Enum representing the status of the property.
     */
    public enum PropertyStatus{
        AVAILABLE,
        UNDER_CONSTRUCTION,
        RENTED
    }
    /**
     * Returns a string representation of the property.
     *
     * @return A string containing the property's ID, address, price, and status.
     */
    @Override
    public String toString() {
        return id + "," + type + "," + location + "," + price + "," + year + "," + rooms + "," + status + "," + size + "," + description + "," + associatedAgent;
    }
//    @Override
//    public String toString() {
//        return "Property{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", location='" + location + '\'' +
//                ", price=" + price + "€"+
//                ", year=" + year +
//                ", rooms=" + rooms +
//                ", status='" + status + '\'' +
//                ", size=" + size + " m^2" +
//                ", description='" + description + '\'' +
//                ", associatedAgent=" + associatedAgent +
//                '}';
//    }
    /**
     * Gets the list of clients who have seen the property.
     *
     * @return The list of clients who have seen the property.
     */
    public List<Client> getSeenByClient() {
        return seenByClient;
    }
    /**
     * Sets the list of clients who have seen the property.
     *
     * @param seenByClient The list of clients who have seen the property.
     */
    public void setSeenByClient(List<Client> seenByClient) {
        this.seenByClient = seenByClient;
    }
    /**
     * Sets the unique identifier of the property.
     *
     * @param id The unique identifier of the property.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Gets the type of the property.
     *
     * @return The type of the property.
     */
    public PropertyType getType() {
        return type;
    }
    /**
     * Sets the type of the property.
     *
     * @param type The type of the property.
     */
    public void setType(PropertyType type) {
        this.type = type;
    }
    /**
     * Gets the location of the property.
     *
     * @return The location of the property.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Sets the location of the property.
     *
     * @param location The location of the property.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Gets the price of the property.
     *
     * @return The price of the property.
     */
    public double getPrice() {
        return price;
    }
    /**
     * Sets the price of the property.
     *
     * @param price The price of the property.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Gets the year the property was built.
     *
     * @return The year the property was built.
     */
    public Integer getYear() {
        return year;
    }
    /**
     * Sets the year the property was built.
     *
     * @param year The year the property was built.
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * Gets the number of rooms in the property.
     *
     * @return The number of rooms in the property.
     */
    public Integer getRooms() {
        return rooms;
    }
    /**
     * Sets the number of rooms in the property.
     *
     * @param rooms The number of rooms in the property.
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    /**
     * Gets the status of the property.
     *
     * @return The status of the property.
     */
    public PropertyStatus getStatus() {
        return status;
    }
    /**
     * Sets the status of the property.
     *
     * @param status The status of the property.
     */
    public void setStatus(PropertyStatus status) {
        this.status = status;
    }
    /**
     * Gets the size of the property.
     *
     * @return The size of the property.
     */
    public double getSize() {
        return size;
    }
    /**
     * Sets the size of the property.
     *
     * @param size The size of the property.
     */
    public void setSize(double size) {
        this.size = size;
    }
    /**
     * Gets the description of the property.
     *
     * @return The description of the property.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the property.
     *
     * @param description The description of the property.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Gets the agent associated with the property.
     *
     * @return The agent associated with the property.
     */
    public Agent getAssociatedAgent() {
        return associatedAgent;
    }
    /**
     * Sets the agent associated with the property.
     *
     * @param associatedAgent The agent associated with the property.
     */
    public void setAssociatedAgent(Agent associatedAgent) {
        this.associatedAgent = associatedAgent;
    }
    /**
     * Gets the date the property was listed.
     *
     * @return The date the property was listed.
     */
    public LocalDate getListedDate() {
        return listDate;
    }
    /**
     * Sets the date the property was listed.
     *
     * @param listDate The date the property was listed.
     */
    public void setListedDate(LocalDate listDate) {
        this.listDate = listDate;
    }
    /**
     * Gets the date the property was sold.
     *
     * @return The date the property was sold.
     */
    public LocalDate getSoldDate() {
        return soldDate;
    }
    /**
     * Sets the date the property was sold.
     *
     * @param soldDate The date the property was sold.
     */
    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }
}
