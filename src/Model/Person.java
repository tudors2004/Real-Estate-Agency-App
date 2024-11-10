package Model;
/**
 * Represents a person in the real estate agency.
 */
public abstract class Person {
    protected Integer id;
    protected String Name;
    protected Integer Phone_Number;
    protected String Email;
    /**
     * Constructs a Person object with the specified ID, name, phone number, and email.
     *
     * @param id          The unique identifier of the person.
     * @param Name        The name of the person.
     * @param phone_number The phone number of the person.
     * @param email       The email address of the person.
     */
    public Person(Integer id, String Name, Integer phone_number, String email){
        this.id=id;
        this.Name=Name;
        this.Phone_Number=phone_number;
        this.Email=email;
    }
    /**
     * Gets the unique identifier of the person.
     *
     * @return The unique identifier of the person.
     */
    public Integer getId(){
        return this.id;
    }
    /**
     * Sets the unique identifier of the person.
     *
     * @param id The unique identifier of the person.
     */
    public void setID(Integer id){
        this.id=id;
    }
    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName(){
        return this.Name;
    }
    /**
     * Sets the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name){
        this.Name=name;
    }
    /**
     * Gets the phone number of the person.
     *
     * @return The phone number of the person.
     */
    public Integer getPhone_numb(){
        return this.Phone_Number;
    }
    /**
     * Sets the phone number of the person.
     *
     * @param phone_numb The phone number of the person.
     */
    public void setPhone_numb(Integer phone_numb){
        this.Phone_Number=phone_numb;
    }
    /**
     * Gets the email address of the person.
     *
     * @return The email address of the person.
     */
    public String getEmail(){
        return this.Email;
    }
    /**
     * Sets the email address of the person.
     *
     * @param email The email address of the person.
     */
    public void setEmail(String email){
        this.Email=email;
    }
}
