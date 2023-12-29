package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable {
    protected String name;
    protected String emailId;
    protected String phoneNumber;
    protected String address;
    protected String dob;

    public void setName(String name){
        this.name=name;
    }

    public void setEmailId(String emailId){
        this.emailId=emailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
