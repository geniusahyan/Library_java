package pkg_transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
// import java.util.ListIterator;

// import pkg_person.Student;

public class BookTransactionManager {
    ObjectOutputStream oos_book_transaction = null;
    ObjectInputStream ois_book_transaction = null;

    File book_transaction_file = null;

    ArrayList<BookTransaction> book_transaction_list = null;
    @SuppressWarnings("unchecked")
    public BookTransactionManager(){
        book_transaction_file = new File("book_transaction.dat");
        book_transaction_list = new ArrayList<>();
        try{
            if(book_transaction_file.exists()){
                ois_book_transaction = new ObjectInputStream(new FileInputStream(book_transaction_file));
                book_transaction_list = (ArrayList<BookTransaction>) ois_book_transaction.readObject();
                ois_book_transaction.close();
            }
        }catch(Exception e){e.printStackTrace();}
    }

   public boolean issueBook(int rollNo, int isbn){
    int total_books_issued = 0;

    for(BookTransaction book_Transaction:book_transaction_list){
        if((book_Transaction.getRollNo() == rollNo) && (book_Transaction.getReturnDate()==null)){
            total_books_issued +=1;
        }
        if (total_books_issued >= 3) {
            return false;
        }
    }
    String issue_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    BookTransaction book_transaction = new BookTransaction(isbn,rollNo);
    book_transaction.setIssueDate(issue_date);
    book_transaction_list.add(book_transaction);
    return true;
   }

   public boolean returnBook(int rollNo, int isbn){
    for(BookTransaction book_transaction:book_transaction_list){
        if ((book_transaction.getRollNo() == rollNo)&&(book_transaction.getIsbn() == isbn)){
            String return_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            book_transaction.setReturnDate(return_date);
            return true;
        }
    }
    return false;
   }

   public void showAll(){
    for(BookTransaction book_transaction:book_transaction_list)
        System.out.println(book_transaction);
   }

   public void writeToFile() throws FileNotFoundException, IOException{
    oos_book_transaction = new ObjectOutputStream(new FileOutputStream(book_transaction_file));
    oos_book_transaction.writeObject(book_transaction_list);
   }

}
