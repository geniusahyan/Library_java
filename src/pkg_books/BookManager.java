package pkg_books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class BookManager {
    ObjectOutputStream oos_book = null;
    ObjectInputStream ois_book = null;

    File book_file = new File("Books.dat");

    ArrayList<Book> book_list = null;

    @SuppressWarnings("unchecked")
    // create constructor 
    public BookManager(){
        if(book_file.exists()) {
            try{
            ois_book = new ObjectInputStream(new FileInputStream(book_file));
            book_list = (ArrayList<Book>) ois_book.readObject();
            }catch(Exception e){e.printStackTrace();}
        }
    }

    public void listBooksBySubject(String subject){
        for(Book book:book_list){
            if(subject.equalsIgnoreCase(book.getSubject())){
                System.out.println(book);
            }
        }
    }

    public void addBook(Book book){
        book_list.add(book);
    }

    public void viewAllBooks(){
        for(Book book:book_list){
            System.out.println(book);
        }
    }

    public int getNumberOfBooks() {
        return book_list.size();
    }

    public Book searchBookByIsbn(int search_isbn){
        for(Book book:book_list){
            if(book.getIsbn() == search_isbn){
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int delete_isbn){
        ListIterator<Book> book_Iterator = (ListIterator<Book>) book_list.listIterator();
        while(book_Iterator.hasNext()){
            Book book = book_Iterator.next();
            if(book.getIsbn()==delete_isbn){
                // book_Iterator.remove();
                return book_list.remove(book);
            }
        }
        return false;
    }

    public boolean updateBook(int update_isbn,String title, String author, String publisher, int edition, String subject, int available_quantity){
        ListIterator<Book> book_Iterator = (ListIterator<Book>) book_list.listIterator();
        while(book_Iterator.hasNext()){
            Book book = book_Iterator.next();
            if(book.getIsbn()==update_isbn){
                book.setAuthor(author);
                book.setAvailableQuantity(available_quantity);
                book.setEdition(edition);
                book.setSubject(subject);
                book.setPublisher(publisher);
                book.setTitle(title);
                return true;
            }
        }
        return false;
    }
    public void writeToFile() throws FileNotFoundException, IOException{
        oos_book = new ObjectOutputStream(new FileOutputStream(book_file));
        oos_book.writeObject(book_list);
    }

}
