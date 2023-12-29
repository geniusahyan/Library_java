package pkg_person;

import java.util.regex.Pattern;

abstract public class Person {
    protected String name;
    protected String emailId;
    protected String phoneNumber;
    protected String address;
    protected String dob;

    public void setName(String name){ 
        // Regular expression to check the Name
        boolean isValidName = Pattern.matches("[a-zA-Z]", name);
        if (isValidName) this.name=name;
    }

    public void setEmailId(String emailId){
        // Regular expression to check the Email ID
        boolean isValidEmail = Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$" ,emailId);
        if (isValidEmail) this.emailId=emailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Regular expression to check the Phone Number
        boolean isValidPhoneNumber = Pattern.matches("[0-9]{10}", phoneNumber);
        if (isValidPhoneNumber) this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address){this.address = address;}

    public void setDob(String dob){
        // Regular expression to check the dob
        boolean isValidDob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
        if (isValidDob) {
            this.dob = dob;
        }else{
            this.dob = "25-02-2005";
        }
    }

    //Methods to get the attributes of a person
    public String getName(){return this.name;}

    public String getEmailId(){ return this.emailId;}

    public String getPhoneNumber(){ return this.phoneNumber;}

    public String getAddress(){ return this.address;}

    public String getDob(){
        return this.dob;
    }

    public Person() {
        super();
    }
    public Person(String name, String emailId, String phoneNumber, String address, String dob) {
        this.setName(name);;
        this.setEmailId(emailId);
        this.setPhoneNumber(phoneNumber);
        this.address = address;
        this.setDob(dob); ;
        }
}
