package org.example.Model;
/**
 * Represents a person in the real estate agency.
 */
public abstract class Person {
    protected Integer id;
    protected String name;
    protected Integer phoneNumber;
    protected String email;

    /**
     * Constructs a Person object with the specified ID, name, phone number, and email.
     *
     * @param id          The unique identifier of the person.
     * @param name        The name of the person.
     * @param phoneNumber The phone number of the person.
     * @param email       The email address of the person.
     */
    public Person(Integer id, String name, Integer phoneNumber, String email) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    /**
     * Constructs a Person object with default values.
     */
    public Person(){}
    /**
     * Gets the unique identifier of the person.
     *
     * @return The unique identifier of the person.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the person.
     *
     * @param id The unique identifier of the person.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return The phone number of the person.
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber The phone number of the person.
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address of the person.
     *
     * @return The email address of the person.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param email The email address of the person.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
