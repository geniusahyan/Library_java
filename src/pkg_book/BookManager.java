

import java.io.File;
import java.io.FileInputStream;
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

    public Book searchBookByIsbm(int search_isbm){
        for(Book book:book_list){
            if(book.getIsbn() == search_isbm){
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int delete_isbn){
        ListIterator<Book> book_Iterator = (ListIterator<Book>) book_list.iterator();
        while(book_Iterator.hasNext()){
            Book book = book_Iterator.next();
            if(book.getIsbn()==delete_isbn){
                // book_Iterator.remove();
                return book_list.remove(book);
            }
        }
        return false;
    }


}
