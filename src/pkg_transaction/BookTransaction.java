package pkg_transaction;

import java.io.Serializable;

public class BookTransaction implements Serializable {
    private int isbn;
    private int rollNo;
    private String issueDate;
    private String returnDate;

    public BookTransaction(int bookIsbn, int studentRollNo) {
        this.isbn = bookIsbn;
        this.rollNo = studentRollNo;
    }
    public BookTransaction(){
        super();
    }
    
    public int getIsbn() {return 0;}
    public void setIsbn(int isbn){this.isbn=isbn;}
    
    public int getRollNo() {return 0;}
    public void setRollNo(int rollNo){this.rollNo=rollNo;}
    public void setIssueDate(String date){this.issueDate=date;}
    public String getIssueDate(){return this.issueDate;}
    public void setReturnDate(String date){this.returnDate=date;}
    public String getReturnDate() {return this.returnDate;}


    public String toString() {
        return "Book [ISBN=" + isbn + ", Roll No= " + rollNo + ", Issue Date= " + issueDate + ",return Date=" + returnDate;
    }
}
