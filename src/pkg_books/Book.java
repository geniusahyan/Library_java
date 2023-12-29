package pkg_books;


public class Book {
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private int edition;
    private String subject;
    private int available_quantity;

    // for all getter setter method 
    public int getIsbn() {return isbn;}
    public void setIsbn(int isbn) {this.isbn = isbn;}

    public String getTitle() {return title;}
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author; }

    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {this.publisher = publisher;}

    public int getEdition() {return edition;}
    public void setEdition(int edition) {this.edition = edition;}

    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    public int getAvailableQuantity() {return available_quantity;}
    public void setAvailableQuantity(int available_quantity) {this.available_quantity = available_quantity;}

    // create a constructor 
    public Book(int isbn, String title, String author, String publisher, int edition, String subject, int available_quantity){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.subject = subject;
        this.available_quantity = available_quantity;
    }

    public Book(){
        super();
    }
    public String toString(){
        return "Book [ISBN=" + isbn + ", Title=" + title + ", Author=" + author + ", Publisher=" + publisher + "edition=" + edition + "subject=" + subject + "available_quantity=" + available_quantity;
    }
}
