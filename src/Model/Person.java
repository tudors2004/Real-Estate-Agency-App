package Model;


public abstract class Person {
    protected Integer id;
    protected String Name;
    protected Integer Phone_Number;
    protected String Email;
    public Person(Integer id, String Name, Integer phone_number, String email){
        this.id=id;
        this.Name=Name;
        this.Phone_Number=phone_number;
        this.Email=email;
    }
    public Integer getId(){
        return this.id;
    }
    public void setID(Integer id){
        this.id=id;
    }
    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name=name;
    }
    public Integer getPhone_numb(){
        return this.Phone_Number;
    }
    public void setPhone_numb(Integer phone_numb){
        this.Phone_Number=phone_numb;
    }
    public String getEmail(){
        return this.Email;
    }
    public void setEmail(String email){
        this.Email=email;
    }
}
