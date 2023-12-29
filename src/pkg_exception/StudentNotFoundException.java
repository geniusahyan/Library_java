package pkg_exception;

public class StudentNotFoundException extends Exception {
    // private static final long serialVersionUid = 1L;
    public StudentNotFoundException(){
        super();
    }

    @Override
    public String toString(){
        return "Student not found!";
    }
}
