package pkg_main;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BookTransactionManager;

import java.rmi.StubNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        // BookManager bm = new BookManager();
        BookMa
        StudentManager sm = new StudentManager();
        BookTransactionManager btm = new BookTransactionManager();

        do{
            System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if want to Exit ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter your Roll Number");
                int rollNumber = sc.nextInt();
                try {
                    Student s = sm.get(rollNumber);
                    if(s == null){
                        throw new StudentNotFoundException();
                    }

                    int stud_choice ;
                    do {
                        System.out.println("Enter 1 to view all Books\nEnter 2 to search Book by isbn\nEnter 3 to search Book by subject\nEnter 4 to issue a Book\nEnter 5 to return a book ");
                        stud_choice = sc.nextInt();
                        switch (stud_choice) {
                            case 1:
                                System.out.println("View all selected");
                                break;
                            case 2:
                                System.out.println("Search by isbn");
                                break;
                            case 3:
                                System.out.println("Search by subject");
                                break;
                            case 4:
                                System.out.println("Issual of book");
                                break;
                            case 5:
                                System.out.println("Return of Book");
                                break;
                            case 99:
                                System.out.println("thx ja fir ab");
                                break;
                            default :
                                System.out.println("Invalid Choice");
                        }
                    }while(stud_choice != 99);
                } catch (StubNotFoundException snfe) {
                    System.out.println(snfe);
                }
            }


        }while(choice != 3);
    }
}
