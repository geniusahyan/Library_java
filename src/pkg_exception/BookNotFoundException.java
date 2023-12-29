package pkg_exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(){

    }   
    
    public String toString(){
        return "Book not found!";
    }
}
