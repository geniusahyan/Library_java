package pkg_main;
import pkg_books.Book;
import pkg_books.BookManager;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BookTransactionManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {
        int choice;
        Scanner sc = new Scanner(System.in);
        
        BookManager bm = new BookManager();
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
                } catch (StudentNotFoundException snfe) {
                    System.out.println(snfe);
                }
            }else if (choice == 2) {

                int lib_choice;
                do{
                System.out.println("Enter 11 to view all Student\nEnter 12 to print a Student by Roll Number\nEnter 13 to Register a Student\nEnter 14 to delete a Student\nEnter 15 to update a Student");
                System.out.println("Enter 21 to view all Books\nEnter 22 to print a Book by ISBN\nEnter 23 to Add a new Book\nEnter 24 to delete a Book\nEnter 25 to update a Book");
                System.out.println("Enter 31 to view all Transaction");
                System.out.println("Enter 99 to Exit");
                lib_choice = sc.nextInt();



                switch (lib_choice) {
                            case 11:
                                System.out.println("All the Students Records");
                                sm.viewAllStudents();
                                break;

                            case 12:
                                System.out.println("Enter roll number to fetch student record");
                                int get_rollNo = sc.nextInt();
                                Student student = sm.get(get_rollNo);
                                if (student == null) {
                                    System.out.println("No Record matches this roll no");
                                }else{
                                    System.out.println(student);
                                }
                                break;

                            case 13:
                                System.out.println("Enter Students Details to add Student");
                                String name,emailId,phoneNumber,address,dob,division;
                                int rollNo,std;
                                // sc.nextLine();
                                System.out.print("Name : ");
                                name=sc.nextLine();

                                System.out.print("Email ID : ");
                                emailId=sc.nextLine();

                                System.out.print("Phone Number : ");
                                phoneNumber=sc.nextLine();

                                System.out.print("Address : ");
                                address=sc.nextLine();

                                System.out.print("Date of Birth(dd/mm/yyyy): ");
                                dob=sc.nextLine();

                                System.out.print("Roll No as Integer : ");
                                rollNo=sc.nextInt();
                                
                                System.out.print("Standard as Integer: ");
                                std=sc.nextInt();
                                
                                System.out.print("Division : ");
                                division=sc.nextLine();
                                // sc.nextLine();

                                student = new Student( name,  emailId ,  phoneNumber ,  address , dob, rollNo , std ,  division);
                                sm.addStudent(student);
                                System.out.println("Student is added");
                                break;

                            case 15:
                                System.out.println("Enter the rollNo to update the record");
                                int upd_rollNo = sc.nextInt();
                                student = sm.get(upd_rollNo);
                                try {
                                    if (student == null) {
                                        throw new StudentNotFoundException();
                                    }

                                    sc.nextLine();
                                    System.out.print("Name : ");
                                    name=sc.nextLine();

                                    System.out.print("Email ID : ");
                                    emailId=sc.nextLine();

                                    System.out.print("Phone Number : ");
                                    phoneNumber=sc.nextLine();

                                    System.out.print("Address : ");
                                    address=sc.nextLine();

                                    System.out.print("Date of Birth(dd/mm/yyyy): ");
                                    dob=sc.nextLine();

                                    System.out.print("Standard as Integer: ");
                                    std=sc.nextInt();
                                    
                                    System.out.print("Division : ");
                                    division=sc.nextLine();
                                    sm.updateStudent(upd_rollNo, name, emailId, phoneNumber, address, dob, std, division);
                                    System.out.println("Student Record is updated");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                
                                break;

                            case 14:
                                System.out.println("Enter the roll numner to delete student ");
                                int delete_rollNo = sc.nextInt();
                                if (sm.deleteStudent(delete_rollNo)) {
                                    System.out.println("Student Record is Removed");
                                }else{
                                    System.out.println("No Record with given roll numbr exist");
                                }
                                break;
                            case 21:
                                bm.viewAllBooks();
                                break;


                            case 22:
                                int search_isbn;
                                System.out.println("Enter ISBN of the Book to search");    
                                search_isbn = sc.nextInt();
                                Book book = bm.searchBookByIsbn(search_isbn);
                                if (book == null) {
                                    System.out.println("No Book with this ISBN Exists in out library");
                                }else{System.out.println(book);}   
                                break;


                            case 23:
                                System.out.println("Enter Book Details to add");    
                                int isbn;
                                String title;
                                String author;
                                String publisher;
                                int edition;
                                String subject;
                                int available_quantity;
                                System.out.println("Enter isbn");
                                isbn = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Title");
                                title = sc.nextLine();
                                System.out.println("Author");
                                author = sc.nextLine();
                                System.out.println("Publisher");
                                publisher = sc.nextLine();
                                System.out.println("Edition");
                                edition = sc.nextInt();
                                System.out.println("Subject");
                                subject = sc.nextLine();
                                System.out.println("Available quantity");
                                available_quantity = sc.nextInt();

                                book = new Book(isbn, title, author, publisher, edition, subject,  available_quantity);

                                break;


                            case 24:
                                System.out.println();    
                                break;


                            case 25:
                                System.out.println();    
                                break;



                            case 99:
                                System.out.println("thx ja fir ab");
                                break;

                            default :
                                System.out.println("Invalid Choice");
                        }
                    }while (lib_choice != 99);

            }

        }while(choice != 3);
        sc.close();
        sm.writeToFile();
    }
}
