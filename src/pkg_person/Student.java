package pkg_person;

public class Student extends Person {
    private int rollNo ;
    private int std;
    private String division ;

    // create getter setter 
    public void setRollNo(int rollNo) {this.rollNo = rollNo;}
    public int getRollNo() {return this.rollNo;}
    public void setStd(int std){this.std=std;}
    public int getStd(){ return this.std;}
    public void setDivision(String division){this.division=division;}
    public String getDivision(){return this.division;}

    // create constructor with parameter 
    public Student(String name, String emailId , String phoneNumber , String address , String dob, int rollNo , int std , String division){
       super(name ,emailId ,phoneNumber ,address ,dob);
    }
    public Student(){
        super();
    }

    public String toString(){
        return "Student [rollNo=" + rollNo + ",emailId=" + emailId + ",phoneNumber=" + phoneNumber + ",address="+ address + ",dob=" + dob + ",rollNo=" + rollNo + ",std=" + std + ",division=" + division + "]";
    }
}
