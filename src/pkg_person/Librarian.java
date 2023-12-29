package pkg_person;

public class Librarian extends Person {
    private int id;
    private String doj;

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getDoj() { return this.doj; }
    public void setDoj(String doj) {this.doj = doj;}

    
    public String toString(){
        return "Librarian [ID: "+getId()+", Name: "+getName()+" ,Address: "+getAddress()+ ",Phone Number: "+getPhoneNumber() + ", Date of Joining: "+getDoj()+"]";
    }
    public Librarian(String name, String emailId, String phoneNumber, String address , String dob , int id , String doj){
        super(name, emailId, phoneNumber, address, dob);
        this.id = id;
        this.doj = doj;
    }
    public Librarian(){
        super();
    }
}
